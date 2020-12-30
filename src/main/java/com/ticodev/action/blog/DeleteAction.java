package com.ticodev.action.blog;

import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.BlogBoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction extends BlogUrlPreprocessor {

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        if (!isBlogger) {
            return AlertAction.forwardError(request);
        }

        int num;
        try {
            num = Integer.parseInt(request.getParameter("num"));
        } catch (NumberFormatException e) {
            return AlertAction.forwardError(request);
        }

        BlogBoardDao dao = new BlogBoardDao();
        if (dao.deleteBoardByNum(num)) {
            return AlertAction.forward(request, "삭제되었습니다.", "list.blog");
        } else {
            return AlertAction.forwardBeforePage(request, "서버 에러 발생");
        }
    }

}
