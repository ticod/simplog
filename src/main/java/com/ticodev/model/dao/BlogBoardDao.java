package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.BlogBoard;
import com.ticodev.model.mapper.BlogBoardMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogBoardDao extends BaseDao<BlogBoardMapper> {

    public BlogBoardDao() {
        super(BlogBoardMapper.class);
    }

    public boolean insertBoard(BlogBoard board) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).insertBoard(board) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

}
