package com.ticodev.action.main;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        MemberDao dao = new MemberDao();
        Member member = new Member();

        String pw = request.getParameter("pw");
        HashEncoder encoder = new HashEncoder(pw);

        member.setMbId(request.getParameter("id").trim());
        member.setMbPassword(encoder.getEncodedMsg());
        member.setMbSalt(encoder.getSalt());
        member.setMbEmail(request.getParameter("email").trim());

        String msg = "회원가입 오류";
        String url = "signup_form.do";
        if (dao.insertMember(member)) {
            msg = "회원가입 완료";
            url = "index.do";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("url", url);

        return AlertAction.forward();
    }

}
