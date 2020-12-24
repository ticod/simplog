package com.ticodev.action.blog;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        BlogUrlProcessor.processURI(request);
        return BlogUrlProcessor.getActionForward(request);
    }
}
