package com.ticodev.action.blog;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BlogLoginAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /* 로그인 여부 확인 */

        return doExecute(request, response);
    }

    abstract public ActionForward doExecute(HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception;

}
