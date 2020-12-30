package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoUpdateAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        MemberDao dao = new MemberDao();

        String sessionId = (String) request.getSession().getAttribute("login");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String birth = request.getParameter("birth");
        String profileImage = request.getParameter("profileImagePath");
        String intro = request.getParameter("intro");

        Member member = dao.selectMemberById(sessionId);

        member.setMbName(name);
        member.setMbTel(tel);
        member.setMbBirthday(birth);
        member.setMbProfileImage(profileImage);
        member.setMbProfileIntro(intro);

        String msg = "정보 수정 실패.. 관리자에게 문의하세요";
        String url = "info.do";
        if (dao.updateProfile(member)) {
            msg = "정보 수정 성공!";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("url", url);

        return AlertAction.forward();
    }

}
