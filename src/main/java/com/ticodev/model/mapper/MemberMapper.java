package com.ticodev.model.mapper;

import com.ticodev.model.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    void updateLoginDate(int num);

    @Update("update member set " +
            "mb_name = #{mbName}, " +
            "mb_tel = #{mbTel}, " +
            "mb_birthday = #{mbBirthday}, " +
            "mb_profile_image = #{mbProfileImage}, " +
            "mb_profile_intro = #{mbProfileIntro} " +
            "where mb_num = #{mbNum}")
    int updateProfile(Member member);

    @Update("update member set " +
            "mb_password = #{password}, " +
            "mb_salt = #{salt} " +
            "where mb_num = #{num}")
    int updatePassword(@Param("num") int num,
                       @Param("password") String password,
                       @Param("salt") String salt);

}
