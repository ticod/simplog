package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.Member;
import com.ticodev.model.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class MemberDao extends BaseDao<MemberMapper> {

    public MemberDao() {
        super(MemberMapper.class);
    }

    public Member selectMemberById(String id) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectMemberById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public Member selectMemberByEmail(String email) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).selectMemberByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return null;
    }

    public boolean insertMember(Member member) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).insertMember(member) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }

        return false;
    }

    public void updateLoginDate(int num) {
        SqlSession session = DbConnection.getConnection();

        try {
            session.getMapper(cls).updateLoginDate(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
    }

    public boolean updateProfile(Member member) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).updateProfile(member) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

    public boolean updatePassword(int num, String pw, String salt) {
        SqlSession session = DbConnection.getConnection();

        try {
            return session.getMapper(cls).updatePassword(num, pw, salt) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            allClose(session);
        }
        return false;
    }

}
