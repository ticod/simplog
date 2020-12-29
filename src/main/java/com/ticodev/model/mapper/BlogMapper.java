package com.ticodev.model.mapper;

import com.ticodev.model.dto.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BlogMapper {

    @Select("select * from blog, member " +
            "where blog.mb_num = member.mb_num and mb_id = #{id}")
    List<Blog> selectBlogByMemberId(String id);

    @Select("select * from blog where bg_url = #{url}")
    Blog selectBlogByUrl(String url);

    @Insert("insert into blog " +
            "(mb_num, bt_type, bg_name, bg_url, bg_intro) " +
            "values " +
            "(#{mbNum}, #{btType}, #{bgName}, #{bgUrl}, #{bgIntro})")
    int insertBlog(Blog blog);

}
