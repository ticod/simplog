package com.ticodev.action.module;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogTypeDao;
import com.ticodev.model.dto.BlogType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainSearchBarAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        BlogTypeDao blogTypeDao = new BlogTypeDao();
        List<BlogType> blogTypes = blogTypeDao.selectAll();
        request.setAttribute("blogTypes", blogTypes);

        return new ActionForward();
    }

}
