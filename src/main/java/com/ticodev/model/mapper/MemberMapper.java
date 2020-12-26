package com.ticodev.model.mapper;

import com.ticodev.model.dto.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {

    @Select("select * from member where mb_id = #{id}")
    Member selectMember(String id);

}
