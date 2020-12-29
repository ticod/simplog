package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.MemberRecommend;
import com.ticodev.model.mapper.MemberRecommendMapper;
import org.apache.ibatis.session.SqlSession;

public class MemberRecommendDao extends BaseDao<MemberRecommendMapper> {

    public static final int CANCEL = 1;
    public static final int RECOMMEND = 0;

    public static final int BLOG = 0;
    public static final int BOARD = 1;
    public static final int COMMENT = 2;

    public MemberRecommendDao() {
        super(MemberRecommendMapper.class);
    }

    public MemberRecommend selectRecommendByContent(int memberNum,
                                                    int contentType,
                                                    int contentNum) {

        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls)
                    .selectRecommendByContent(memberNum, contentType, contentNum);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;

    }

    public boolean insertRecommend(int memberNum,
                                   int contentType,
                                   int contentNum) {

        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls)
                    .insertRecommend(memberNum, contentType, contentNum) > 0;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }

        return false;

    }

    public boolean updateRecommend(boolean isCancel) {

        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls)
                    .updateRecommend(isCancel) > 0;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }

        return false;

    }

}
