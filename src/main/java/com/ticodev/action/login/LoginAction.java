package com.ticodev.action.login;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

    MemberDao dao = new MemberDao();

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("loginId");
        String pw = request.getParameter("loginPw");
        Member target = dao.selectMember(id);

        request.setAttribute("url", "../main/login_form.do");
        // id에 해당하는 회원 없음
        if (target == null) {
            request.setAttribute("msg", "아이디를 확인하세요");
        } else {
            HashEncoder encoder = new HashEncoder("SHA-256", pw, target.getMbSalt());
            String encodedPw = encoder.getEncodedMsg();
            // 비밀번호가 일치하는 경우
            if (encodedPw.equals(target.getMbPassword())) {
                request.getSession().setAttribute("login", id);
                request.setAttribute("msg", target.getMbName() + "님이 로그인 했습니다");
                request.setAttribute("url", "index.do");
            } else {
                request.setAttribute("msg", "비밀번호를 확인하세요");
            }
        }

        return new ActionForward(false, "/alert.jsp");
    }
}
