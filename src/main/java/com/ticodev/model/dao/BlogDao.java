package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.Blog;
import com.ticodev.model.mapper.BlogMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogDao extends BaseDao<BlogMapper> {

    public BlogDao() {
        super(BlogMapper.class);
    }

    public List<Blog> selectBlogByMemberId(String id) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectBlogByMemberId(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public Blog selectBlogByUrl(String url) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectBlogByUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public boolean insertBlog(Blog blog) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).insertBlog(blog) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }

        return false;
    }

}
