package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordChangeAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String sessionId = (String) request.getSession().getAttribute("login");
        MemberDao dao = new MemberDao();
        Member member = dao.selectMemberById(sessionId);

        String currentPwParameter = request.getParameter("currentPw");
        String changePw = request.getParameter("pw");

        HashEncoder encoder
                = new HashEncoder(currentPwParameter, member.getMbSalt());
        String encodedPw = encoder.getEncodedMsg();

        String msg = "현재 비밀번호를 다시 확인해주세요.";
        String url = "password_change.do";
        if (member.getMbPassword().equals(encodedPw)) {
            encoder = new HashEncoder(changePw);
            String pw = encoder.getEncodedMsg();
            String salt = encoder.getSalt();
            if (dao.updatePassword(member.getMbNum(), pw, salt)) {
                msg = "비밀번호 변경 성공!";
            } else {
                msg = "비밀번호 변경 실패.. 관리자에게 문의하세요";
            }
        }

        request.setAttribute("msg", msg);
        request.setAttribute("url", url);

        return AlertAction.forward();
    }

}
