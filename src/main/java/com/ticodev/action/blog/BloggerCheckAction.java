package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;
import com.ticodev.action.ErrorAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BloggerCheckAction extends BlogUrlPreprocessor {

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        if (!isBlogger) {
            return ErrorAction.forward(request);
        }

        return getActionForward();

    }

}
