package com.ticodev.action.blog;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action, BlogUrlProcessor {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        processURI(request);
        return getActionForward(request);
    }
}
