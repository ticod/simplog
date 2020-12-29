package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.BlogType;
import com.ticodev.model.mapper.BlogTypeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogTypeDao extends BaseDao<BlogTypeMapper> {

    public BlogTypeDao() {
        super(BlogTypeMapper.class);
    }

    public List<BlogType> selectAll() {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

}
