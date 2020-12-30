package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogBoardDao;
import com.ticodev.model.dto.BlogBoard;
import com.ticodev.util.CookieAdder;
import com.ticodev.util.CookieChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostAction extends BlogUrlPreprocessor {

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        int num;
        try {
            num = Integer.parseInt(request.getParameter("num"));
        } catch (NumberFormatException e) {
            return getErrorActionForward(request);
        }

        BlogBoardDao dao = new BlogBoardDao();
        BlogBoard board = dao.selectBoardByNum(num);
        if (board == null || board.isBbIsDelete()) {
            return getErrorActionForward(request, "서버 에러 발생");
        }

        if (!CookieChecker.hasBoardCookie(request, board.getBbNum())) {
            if (dao.addHits(board.getBbNum())) {
                response.addCookie(CookieAdder.getBoardCookie(board.getBbNum()));
            } else {
                System.out.println("서버 에러 발생");
            }
        }

        request.setAttribute("board", board);

        return getActionForward();
    }
}
