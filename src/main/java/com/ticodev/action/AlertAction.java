package com.ticodev.action;

import javax.servlet.http.HttpServletRequest;

public class AlertAction {

    public static ActionForward forward(HttpServletRequest request, String msg, String url) {
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return new ActionForward(false, "/alert.jsp");
    }

    public static ActionForward forward(boolean redirect) {
        return new ActionForward(redirect, "/alert.jsp");
    }

    public static ActionForward forward() {
        return new ActionForward(false, "/alert.jsp");
    }

    public static ActionForward forwardBeforePage(HttpServletRequest request, String msg) {
        request.setAttribute("msg", msg);
        request.setAttribute("url", request.getHeader("Referer"));
        return new ActionForward(false, "/alert.jsp");
    }

    public static ActionForward forwardBeforePage(HttpServletRequest request) {
        request.setAttribute("url", request.getHeader("Referer"));
        return new ActionForward(false, "/alert.jsp");
    }

    public static ActionForward forwardError(HttpServletRequest request) {
        request.setAttribute("msg", "잘못된 경로입니다.");
        request.setAttribute("url", request.getHeader("Referer"));
        return new ActionForward(false, "/alert.jsp");
    }

}
