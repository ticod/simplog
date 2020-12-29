package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogCategoryDao;
import com.ticodev.model.dao.BlogDao;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Blog;
import com.ticodev.model.dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogCreateAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        MemberDao memberDao = new MemberDao();
        BlogDao blogDao = new BlogDao();
        BlogCategoryDao blogCategoryDao = new BlogCategoryDao();
        String sessionId = (String) request.getSession().getAttribute("login");

        // 반환 메세지
        String msg = "블로그 개설 성공!";
        request.setAttribute("url", "blog_management.do");

        if (blogDao.selectBlogByMemberId(sessionId).size() > 5) {
            request.setAttribute("msg", "블로그 최대 개설 수는 5개입니다.");
            return new ActionForward(false, "/alert.jsp");
        }

        Member member = memberDao.selectMemberById(sessionId);
        int memberNum = member.getMbNum();
        int blogType = Integer.parseInt(request.getParameter("blogType"));
        String blogName = request.getParameter("blogName");
        String blogUrl = request.getParameter("blogUrl");
        String blogIntro = request.getParameter("blogIntro");

        Blog blog = new Blog();
        blog.setMbNum(memberNum);
        blog.setBtType(blogType);
        blog.setBgName(blogName);
        blog.setBgUrl(blogUrl);
        blog.setBgIntro(blogIntro);

        if (!blogDao.insertBlog(blog)) {
            msg = "블로그 개설 실패.. 관리자에게 문의하세요";
        } else {
            blog = blogDao.selectBlogByUrl(blogUrl);
            if (!blogCategoryDao.insertBase(blog.getBgNum())) {
                msg = "블로그 개설 실패.. 관리자에게 문의하세요";
            }
        }

        request.setAttribute("msg", msg);

        return new ActionForward(false, "/alert.jsp");

    }

}
