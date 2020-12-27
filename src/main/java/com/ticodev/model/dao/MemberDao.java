package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import com.ticodev.model.dto.Member;
import com.ticodev.model.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    private final Class<MemberMapper> cls = MemberMapper.class;
    private Map<String, Object> params = new HashMap<>();

    private void allClose(SqlSession session) {
        params.clear();
        DbConnection.close(session);
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

}
