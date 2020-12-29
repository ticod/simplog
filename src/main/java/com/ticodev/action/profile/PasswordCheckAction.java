package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogDao;
import com.ticodev.model.dao.BlogTypeDao;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Blog;
import com.ticodev.model.dto.BlogType;
import com.ticodev.model.dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// 로그인, 패스워드 체크 여부 확인
public class PasswordCheckAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String sessionId = (String) request.getSession().getAttribute("login");
        String sessionCheck = (String) request.getSession().getAttribute("pwCheck");

        if (sessionId == null) {
            request.setAttribute("msg", "로그인 해주세요");
            request.setAttribute("url", "../main/login_form.do");
            return new ActionForward(false, "/alert.jsp");
        }
        
        if (sessionCheck == null) {
            request.setAttribute("url", "../main/password_check.do");
            return new ActionForward(false, "/alert.jsp");
        }

        MemberDao memberDao = new MemberDao();
        BlogDao blogDao = new BlogDao();
        BlogTypeDao blogTypeDao = new BlogTypeDao();

        Member member = memberDao.selectMemberById(sessionId);
        List<Blog> blogs = blogDao.selectBlogByMemberId(sessionId);
        List<BlogType> blogTypes = blogTypeDao.selectAll();

        request.setAttribute("member", member);
        request.setAttribute("blogs", blogs);
        request.setAttribute("blogTypes", blogTypes);

        return new ActionForward();
    }

}
