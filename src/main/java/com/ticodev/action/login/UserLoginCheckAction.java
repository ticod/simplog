package com.ticodev.action.login;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class UserLoginCheckAction implements Action {

    protected String sessionId;

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        sessionId = (String) request.getSession().getAttribute("login");

        /* 로그아웃 상태 */
        if (sessionId == null) {
            request.setAttribute("msg", "로그인 후 이용해주세요");
            request.setAttribute("url", "login_form.do");
            return new ActionForward(false, "/alert.jsp");
        }

        return doExecute(request, response);
    }

    public abstract ActionForward doExecute(HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception;

}
