package com.ticodev.action.blog;

import com.oreilly.servlet.MultipartRequest;
import com.ticodev.action.ActionForward;
import com.ticodev.model.dao.BlogBoardDao;
import com.ticodev.model.dto.BlogBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class WriteAction extends BlogUrlPreprocessor {

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
        String msg = "게시물 등록 실패..";
        String url = "write_form.blog";

        try {
            multi = new MultipartRequest(request, path, FILE_SIZE, ENCODING);
            board.setBgNum(blog.getBgNum());
            board.setCtNum(Integer.parseInt(multi.getParameter("category")));
            board.setBbSubject(multi.getParameter("subject"));
            board.setBbContent(multi.getParameter("content"));
            board.setBbFile(multi.getFilesystemName("file"));
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("msg", msg);
            request.setAttribute("url", url);
            return new ActionForward(false, "/alert.jsp");
        }

        if (dao.insertBoard(board)) {
            return new ActionForward(true, "main.blog");
        } else {
            request.setAttribute("msg", msg);
            request.setAttribute("url", url);
            return new ActionForward(false, "/alert.jsp");
        }
    }

}
