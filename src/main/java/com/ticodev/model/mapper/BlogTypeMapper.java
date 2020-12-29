package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogTypeMapper {

    @Select("select * from blog_type")
    List<BlogType> selectAll();

}
