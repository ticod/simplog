package com.ticodev.action.blog;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Action!");
        return new ActionForward(false, "/blog/main.jsp");
    }
}
