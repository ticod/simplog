package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BloggerCheckAction extends BlogUrlPreprocessor {

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        if (!isBlogger) {
            request.setAttribute("msg", "잘못된 경로입니다.");
            request.setAttribute("url", request.getHeader("Referer"));
            return new ActionForward(false, "/alert.jsp");
        }

        return getActionForward();

    }

}
