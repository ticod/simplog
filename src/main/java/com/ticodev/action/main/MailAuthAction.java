package com.ticodev.action.main;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dto.Member;
import com.ticodev.util.EmailSender;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class MailAuthAction implements Action {

    MemberDao dao = new MemberDao();
    String subject = "Simplog 인증 번호 발신";
    String content = "인증 번호: ";

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String email = request.getParameter("email").trim();

        request.setAttribute("success", "false");

        if (email.equals("")) {
            request.setAttribute("msg", "이메일을 입력하세요");
            return new ActionForward();
        }

        Member member = dao.selectMemberByEmail(email);
        if (member != null) {
            request.setAttribute("msg", "이미 가입한 이메일입니다");
            return new ActionForward();
        }

        String authNumber = String.format("%05d", generateRandomNumber());

        EmailSender sender = new EmailSender();
        HashEncoder encoder = new HashEncoder(authNumber);
        String encodedAuthNumber = encoder.getEncodedMsg();
        request.getSession().setMaxInactiveInterval(300);
        request.getSession().setAttribute("auth", encodedAuthNumber);
        request.getSession().setAttribute("salt", encoder.getSalt());
        request.getSession().setAttribute("email", email);

        if (!sender.sendEmail(email, subject, content + authNumber)) {
            request.setAttribute("msg", "메일 전송 중 오류 발생");
            return new ActionForward();
        }

        request.setAttribute("success", "true");
        request.setAttribute("msg", "인증번호가 전송되었습니다");
        return new ActionForward();
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100000);
    }
}
