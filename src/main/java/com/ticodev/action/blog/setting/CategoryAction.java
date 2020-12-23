package com.ticodev.action.blog.setting;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.blog.BlogUrlProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryAction implements Action, BlogUrlProcessor {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        processURI(request);
        return getActionForward(request);
    }
}
