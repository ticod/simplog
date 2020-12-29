package com.ticodev.action.profile;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogDao;
import com.ticodev.model.dto.Blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlCheckAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String parameterUrl = request.getParameter("url");

        BlogDao dao = new BlogDao();
        Blog blog = dao.selectBlogByUrl(parameterUrl);

        if (blog == null) {
            request.setAttribute("ajaxUrlCheckResult", "true");
        }

        return new ActionForward();
    }

}
