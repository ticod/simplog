package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.MemberRecommend;
import com.ticodev.model.mapper.MemberRecommendMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
                    .selectRecommendByContentAndMember(memberNum, contentType, contentNum);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;

    }

    public List<MemberRecommend> selectRecommendsByMember(int memberNum) {
        SqlSession session = DbConnection.getConnection();
        try {
            return session.getMapper(cls)
                    .selectRecommendsByMember(memberNum);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public int selectCountByContent(int contentType, int contentNum) {
        SqlSession session = DbConnection.getConnection();
        try {
            return session.getMapper(cls)
                    .selectCountByContent(contentType, contentNum);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return 0;
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

    public boolean updateRecommend(boolean isCancel,
                                   int memberNum,
                                   int contentType,
                                   int contentNum) {

        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls)
                    .updateRecommend(isCancel, memberNum, contentType, contentNum) > 0;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }

        return false;

    }

}
