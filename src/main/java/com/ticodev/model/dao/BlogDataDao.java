package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.BlogData;
import com.ticodev.model.mapper.BlogDataMapper;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BlogDataDao extends BaseDao<BlogDataMapper> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public BlogDataDao() {
        super(BlogDataMapper.class);
    }

    public List<BlogData> selectBlogDataByBlogAndTerm(int blogNum, int term) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls)
                    .selectBlogDataByBlogAndTerm(blogNum, term);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public BlogData selectByBlogAndDate(int blogNum, Date date) {
        SqlSession session = DbConnection.getConnection();
        String formattedDate = dateFormat.format(date);

        try {
            return session.getMapper(cls).selectByBlogAndDate(blogNum, formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public boolean initDataBlog(int blogNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).initDataBlog(blogNum) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public boolean addHitsBlog(int blogNum) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).addHitsBlog(blogNum) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

}
