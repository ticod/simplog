package com.ticodev.model.dao;

import com.ticodev.model.DbConnection;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class BaseDao<T> {

    protected final Class<T> cls;
    protected final Map<String, Object> params = new HashMap<>();

    protected BaseDao(Class<T> cls) {
        this.cls = cls;
    }

    protected void allClose(SqlSession session) {
        params.clear();
        DbConnection.close(session);
    }

}
