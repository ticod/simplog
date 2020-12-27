package com.ticodev.action.main;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.util.HashEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailAuthCheckAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String inputNumber = request.getParameter("number");
        String email = request.getParameter("email");

        String salt = (String) request.getSession().getAttribute("salt");
        String authNumber = (String) request.getSession().getAttribute("auth");
        String sessionEmail = (String) request.getSession().getAttribute("email");

        HashEncoder encoder = new HashEncoder("SHA-256", inputNumber, salt);
        String encodedInputNumber = encoder.getEncodedMsg();

        if (encodedInputNumber.equals(authNumber) && email.equals(sessionEmail)) {
            request.setAttribute("authCheck", "true");
        } else {
            request.setAttribute("authCheck", "false");
        }

        return new ActionForward();
    }
}
