package com.ticodev.action.login;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AdminLoginAction implements Action {

    protected String sessionId;

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        MemberDao dao = new MemberDao();
        sessionId = (String) request.getSession().getAttribute("adminLogin");

        /* 로그아웃 상태 */
        if (sessionId == null) {
            return AlertAction.forward(request, "로그인 후 이용해주세요", "../admin/login_form.do");
        }

        Member member = dao.selectMemberById(sessionId);

        /* 관리자가 아닌 경우 */
        if (!member.isMbIsAdmin()) {
            return AlertAction.forward(request, "접근 불가", "../main/index.do");
        }

        return doExecute(request, response);
    }

    public abstract ActionForward doExecute(HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception;

}
