package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.BlogCategorySetting;
import com.ticodev.model.mapper.BlogCategoryMapper;
import com.ticodev.model.mapper.BlogTypeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogCategoryDao extends BaseDao<BlogCategoryMapper> {

    public BlogCategoryDao() {
        super(BlogCategoryMapper.class);
    }

    public boolean insertBase(int blogNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).insertBase(blogNum) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public List<BlogCategorySetting> selectCategoryByBlogNum(int blogNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectCategoryByBlogNum(blogNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public BlogCategorySetting selectCategory(int blogNum, int categoryNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectCategory(blogNum, categoryNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

}
