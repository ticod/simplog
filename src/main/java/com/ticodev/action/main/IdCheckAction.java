package com.ticodev.action.main;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdCheckAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String id = request.getParameter("id").trim();
        MemberDao dao = new MemberDao();
        Member member = dao.selectMemberById(id);

        if (member == null) {
            request.setAttribute("idCheck", "true");
        } else {
            request.setAttribute("idCheck", "false");
        }

        return new ActionForward();
    }

}
