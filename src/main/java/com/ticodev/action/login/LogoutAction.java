package com.ticodev.action.login;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

    MemberDao dao = new MemberDao();

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getSession().invalidate();
        request.setAttribute("msg", "로그아웃하셨습니다");
        request.setAttribute("url", request.getHeader("Referer"));

        return new ActionForward(false, "/alert.jsp");
    }
}
