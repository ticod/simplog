package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogBoardDao;
import com.ticodev.model.dto.BlogBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormAction extends BlogUrlPreprocessor {

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        if (!isBlogger) {
            return getErrorActionForward(request);
        }

        int num;
        try {
            num = Integer.parseInt(request.getParameter("num"));
        } catch (NumberFormatException e) {
            return getErrorActionForward(request);
        }

        BlogBoardDao dao = new BlogBoardDao();
        BlogBoard board = dao.selectBoardByNum(num);
        if (board == null || board.isBbIsDelete()) {
            return getErrorActionForward(request, "삭제된 게시글입니다.");
        }

        request.setAttribute("board", board);

        return getActionForward();
    }

}
