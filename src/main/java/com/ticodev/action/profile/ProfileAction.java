package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL : /profile/profile.do
public class ProfileAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        MemberDao dao = new MemberDao();

        String id = (String) request.getSession().getAttribute("login");
        if (id == null) {
            request.setAttribute("msg", "로그인 후 이용해주세요");
            request.setAttribute("url", "../main/login_form.do");
            return new ActionForward(false, "/alert.jsp");
        }

        String pw = request.getParameter("pw");
        Member member = dao.selectMemberById(id);

        HashEncoder encoder =
                new HashEncoder(pw, member.getMbSalt());
        String encodedPw = encoder.getEncodedMsg();

        if (encodedPw.equals(member.getMbPassword())) {
            request.getSession().setAttribute("pwCheck", "true");
            request.setAttribute("url", "info.do");
        } else {
            request.setAttribute("msg", "비밀번호를 확인하세요");
            request.setAttribute("url", "../main/password_check.do");
        }

        return new ActionForward(false, "/alert.jsp");
    }
}
