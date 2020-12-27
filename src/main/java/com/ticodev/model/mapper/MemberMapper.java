package com.ticodev.model.mapper;

import com.ticodev.model.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberMapper {

    @Select("select * from member where mb_id = #{id}")
    Member selectMemberById(String id);

    @Select("select * from member where mb_email = #{email}")
    Member selectMemberByEmail(String email);

    @Insert("insert into member " +
            "(mb_id, mb_password, mb_salt, mb_email) " +
            "values " +
            "(#{mbId}, #{mbPassword}, #{mbSalt}, #{mbEmail})")
    int insertMember(Member member);

    @Update("update member set " +
            "mb_last_login = now() " +
            "where mb_num = #{num}")
    int updateLoginDate(int num);

}
