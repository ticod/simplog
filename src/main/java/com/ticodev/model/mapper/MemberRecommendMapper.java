package com.ticodev.model.mapper;

import com.ticodev.model.dto.MemberRecommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberRecommendMapper {

    @Select("select * " +
            "from member_recommend " +
            "where " +
            "mb_num = #{memberNum} " +
            "and content_type = #{contentType} " +
            "and content_num = #{contentNum}")
    MemberRecommend selectRecommendByContentAndMember(@Param("memberNum") int memberNum,
                                                      @Param("contentType") int contentType,
                                                      @Param("contentNum") int contentNum);

    @Select("select * " +
            "from member_recommend " +
            "where " +
            "mb_num = #{memberNum} " +
            "and mr_is_cancel = 0")
    List<MemberRecommend> selectRecommendsByMember(@Param("memberNum") int memberNum);

    @Select("select count(*) " +
            "from member_recommend " +
            "where " +
            "content_type = #{contentType} " +
            "and content_num = #{contentNum} " +
            "and mr_is_cancel = 0")
    int selectCountByContent(@Param("contentType") int contentType,
                          @Param("contentNum") int contentNum);

    @Insert("insert into member_recommend " +
            "(mb_num, content_type, content_num) " +
            "values " +
            "(#{memberNum}, #{contentType}, #{contentNum})")
    int insertRecommend(@Param("memberNum") int memberNum,
                        @Param("contentType") int contentType,
                        @Param("contentNum") int contentNum);

    @Update("update member_recommend " +
            "set " +
            "mr_datetime = now(), " +
            "mr_is_cancel = ${isCancel} " +
            "where " +
            "mb_num = #{memberNum} " +
            "and content_type = #{contentType} " +
            "and content_num = #{contentNum}")
    int updateRecommend(@Param("isCancel") boolean isCancel,
                        @Param("memberNum") int memberNum,
                        @Param("contentType") int contentType,
                        @Param("contentNum") int contentNum);

}
