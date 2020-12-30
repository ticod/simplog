package com.ticodev.action.blog;

import com.oreilly.servlet.MultipartRequest;
import com.ticodev.action.ActionForward;
import com.ticodev.action.ErrorAction;
import com.ticodev.model.dao.BlogBoardDao;
import com.ticodev.model.dto.BlogBoard;
import com.ticodev.util.CookieAdder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class UpdateAction extends BlogUrlPreprocessor {

    final static int FILE_SIZE = 10 * 1024 * 1024;
    final static String ENCODING = "utf-8";

    @Override
    public ActionForward doExecute(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {

        BlogBoardDao dao = new BlogBoardDao();
        BlogBoard board = new BlogBoard();

        String path = request.getServletContext().getRealPath("/")
                + "resources/blog_files/";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }

        MultipartRequest multi = null;
        String msg = "게시물 수정 실패..";
        String url = "update_form.blog";

        try {
            multi = new MultipartRequest(request, path, FILE_SIZE, ENCODING);
            board.setBbNum(Integer.parseInt(multi.getParameter("boardNum")));
            board.setCtNum(Integer.parseInt(multi.getParameter("categoryNum")));
            board.setBbSubject(multi.getParameter("subject"));
            board.setBbContent(multi.getParameter("content"));
            board.setBbFile(multi.getFilesystemName("file"));
            if (board.getBbFile() == null || board.getBbFile().trim().equals("")) {
                board.setBbFile(multi.getParameter("currentFile"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ErrorAction.forward(request, msg, url);
        }

        if (dao.updateBoard(board)) {
            return new ActionForward(true, "post.blog?num=" + board.getBbNum());
        } else {
            return ErrorAction.forward(request, msg, url);
        }
    }

}
