package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;

public class BlogUrlProcessor {

    public static void processURI(HttpServletRequest request) {

        String uri = request.getRequestURI().substring(request.getContextPath().length());
        int splitIndex = uri.substring(1).indexOf('/') + 1;
        String blogName = uri.substring(1, splitIndex);
        String url = uri.substring(splitIndex);
        request.setAttribute("blog", blogName);
        request.setAttribute("url", url);

    }

    public static ActionForward getActionForward(HttpServletRequest request) {

        String url = (String) request.getAttribute("url");
        return new ActionForward(false, "/blog" + url.replace(".blog", ".jsp"));

    }

}
