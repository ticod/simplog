package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogBoardDao;
import com.ticodev.model.dao.BlogCategoryDao;
import com.ticodev.model.dto.BlogBoard;
import com.ticodev.model.dto.BlogCategorySetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class ListAction extends BlogUrlPreprocessor {

    private static final int DEFAULT_CATEGORY_NUM = 0;
    private static final int DEFAULT_PAGE_NUM = 1;
    private static final int DEFAULT_LIMIT = 10;

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        BlogBoardDao dao = new BlogBoardDao();

        String find = request.getParameter("find");
        String column = request.getParameter("column");
        List<String> columns = null;

        if (find == null || column == null
                || find.trim().equals("")
                || column.trim().equals("")) {
            find = null;
        } else {
            columns = Arrays.asList(column.split(",").clone());
        }
        System.out.println(columns);

        int categoryNum;
        try {
            categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
        } catch (NumberFormatException e) {
            categoryNum = DEFAULT_CATEGORY_NUM;
        }

        int pageNum;
        try {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        } catch (NumberFormatException e) {
            pageNum = DEFAULT_PAGE_NUM;
        }

        int limit;
        try {
            limit = Integer.parseInt(request.getParameter("limit"));
        } catch (NumberFormatException e) {
            limit = DEFAULT_LIMIT;
        }

        List<BlogBoard> boards =
                dao.selectBoardByBlog(blog.getBgNum(),
                        categoryNum, pageNum, limit, columns, find);

        int boardCount = dao.selectBoardCountByBlog(blog.getBgNum(),
                categoryNum, columns, find);

        BlogCategorySetting currentCategory = new BlogCategoryDao()
                .selectCategory(blog.getBgNum(), categoryNum);

        int pageCount = (int)((double) (boardCount - 1) / limit) + 1;
        int startPage = ((pageNum - 1) / limit) * 10 + 1;
        int endPage = Math.min(startPage + 9, pageCount);
        int boardNum = boardCount - (pageNum - 1) * limit;

        request.setAttribute("boards", boards);
        request.setAttribute("boardCount", boardCount);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("boardNum", boardNum);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("currentCategory", currentCategory);

        return getActionForward();

    }

}
