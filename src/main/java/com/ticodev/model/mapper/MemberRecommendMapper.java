package com.ticodev.model.mapper;

import com.ticodev.model.dto.MemberRecommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberRecommendMapper {

    @Select("select mr_datetime, mr_is_cancel " +
            "from member_recommend " +
            "where" +
            "mb_num = #{memberNum}, " +
            "content_type = #{contentType}, " +
            "content_num = #{contentNum}")
    MemberRecommend selectRecommendByContent(int memberNum,
                                             int contentType,
                                             int contentNum);

    @Insert("insert into member_recommend " +
            "(mb_num, content_type, content_num) " +
            "values " +
            "(#{memberNum}, #{contentType}, #{contentNum})")
    int insertRecommend(int memberNum,
                        int contentType,
                        int contentNum);

    @Update("update member_recommend " +
            "set " +
            "mr_datetime = now(), " +
            "mr_is_cancel = ${isCancel}")
    int updateRecommend(boolean isCancel);

}
