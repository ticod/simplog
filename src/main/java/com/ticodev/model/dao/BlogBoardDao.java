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

    public List<BlogBoard> selectBoardByBlog(int blogNum,
                                             int categoryNum,
                                             int pageNum, int limit,
                                             String column, String find) {

        SqlSession session = DbConnection.getConnection();

        try {
            params.put("blogNum", blogNum);
            params.put("categoryNum", categoryNum);
            params.put("start", (pageNum - 1) * limit);
            params.put("limit", limit);
            // 제목 or 글, 검색 키워드
            if (column != null) {
                params.put("column", column);
                params.put("find", find);
            }
            return session.getMapper(cls).selectBoardByBlog(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public int selectBoardCountByBlog(int blogNum,
                                      int categoryNum,
                                      String column, String find) {
        SqlSession session = DbConnection.getConnection();

        try {
            params.put("blogNum", blogNum);
            params.put("categoryNum", categoryNum);
            if (column != null) {
                params.put("column", column);
                params.put("find", find);
            }
            return session.getMapper(cls).selectBoardCountByBlog(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return 0;
    }

    public BlogBoard selectBoardByNum(int boardNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectBoardByNum(boardNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public boolean addHits(int boardNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).addHits(boardNum) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public boolean updateBoard(BlogBoard board) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).updateBoard(board) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public boolean deleteBoardByNum(int num) {
        SqlSession session = DbConnection.getConnection();
        try {
            return session.getMapper(cls).deleteBoardByNum(num) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }
}
