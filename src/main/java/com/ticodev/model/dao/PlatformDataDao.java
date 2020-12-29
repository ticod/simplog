package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.BlogBoard;
import com.ticodev.model.dto.PlatformData;
import com.ticodev.model.mapper.PlatformDataMapper;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PlatformDataDao extends BaseDao<PlatformDataMapper> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public PlatformDataDao() {
        super(PlatformDataMapper.class);
    }

    public List<PlatformData> selectByTerm(int term) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectByTerm(term);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public PlatformData selectByDate(Date date) {
        SqlSession session = DbConnection.getConnection();
        String formattedDate = dateFormat.format(date);

        try {
            return session.getMapper(cls).selectByDate(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public boolean initData() {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).initData() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public boolean addHits() {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).addHits() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

}
