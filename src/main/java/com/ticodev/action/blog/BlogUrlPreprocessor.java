package com.ticodev.action.blog;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.BlogCategoryDao;
import com.ticodev.model.dao.BlogDao;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dao.MemberRecommendDao;
import com.ticodev.model.dto.Blog;
import com.ticodev.model.dto.BlogCategorySetting;
import com.ticodev.model.dto.Member;
import com.ticodev.model.dto.MemberRecommend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class BlogUrlPreprocessor implements Action {

    protected Blog blog;
    protected boolean isBlogger;
    protected String url;
    protected List<BlogCategorySetting> categoriesTemp;
    protected Map<Integer, List<BlogCategorySetting>> categories;

    public abstract ActionForward doExecute(HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception;

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String uri = request.getRequestURI().substring(request.getContextPath().length());

        int splitIndex = uri.substring(1).indexOf('/') + 1;
        String blogUrl = uri.substring(1, splitIndex);
        String tailUrl = uri.substring(splitIndex);

        // 없는 블로그에 대한 접근
        BlogDao blogDao = new BlogDao();
        blog = blogDao.selectBlogByUrl(blogUrl);
        if (blog == null) {
            return AlertAction.forwardError(request);
        }

        // 실제 url 처리
        url = "/blog" + tailUrl.replace(".blog", ".jsp");

        // 카테고리 가져와서 저장
        BlogCategoryDao blogCategoryDao = new BlogCategoryDao();
        categoriesTemp = blogCategoryDao.selectCategoryByBlogNum(blog.getBgNum());

        categories = new TreeMap<>();
        for (BlogCategorySetting category : categoriesTemp) {
            if (category.getCtParent() == 0) {
                List<BlogCategorySetting> list = new ArrayList<>();
                list.add(category);
                categories.put(category.getCtNum(), list);
            } else {
                categories.get(category.getCtParent()).add(category);
            }
        }

        MemberRecommendDao memberRecommendDao = new MemberRecommendDao();

        // 현재 로그인한 사람의 블로거 여부
        Member member = null;
        MemberRecommend memberRecommend = null;
        String sessionId = (String) request.getSession().getAttribute("login");
        if (sessionId != null) {
            MemberDao dao = new MemberDao();
            member = dao.selectMemberById(sessionId);
            memberRecommend = memberRecommendDao
                    .selectRecommendByContent(member.getMbNum(), 0, blog.getBgNum());
            request.setAttribute("memberRecommend", memberRecommend);
            isBlogger = member.getMbNum() == blog.getMbNum();
        } else {
            isBlogger = false;
        }


        int blogRecommendCount = memberRecommendDao
                .selectCountByContent(0, blog.getBgNum());


        request.setAttribute("member", member);
        request.setAttribute("isBlogger", isBlogger);
        request.setAttribute("blog", blog);
        request.setAttribute("url", tailUrl);
        request.setAttribute("categories", categories);
        request.setAttribute("blogRecommendCount", blogRecommendCount);

        return doExecute(request, response);
    }

    // 다른 url 변경 없이 반환할 때 사용
    protected ActionForward getActionForward() {
        return new ActionForward(false, url);
    }

}
