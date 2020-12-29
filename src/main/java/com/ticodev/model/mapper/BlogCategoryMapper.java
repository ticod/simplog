package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogCategorySetting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogCategoryMapper {

    @Insert("insert into blog_category_setting (ct_num, bg_num, ct_sequence, ct_parent, ct_name) " +
            "values (0, #{blogNum}, 0, 0, '전체 글 보기')")
    int insertBase(int blogNum);

    @Select("select * from blog_category_setting where bg_num = #{blogNum} and ct_num > 0 " +
            "order by ct_parent, ct_sequence")
    List<BlogCategorySetting> selectCategoryByBlogNum(int blogNum);

    @Select("select * from blog_category_setting " +
            "where bg_num = #{blogNum} and ct_num = #{categoryNum} ")
    BlogCategorySetting selectCategory(@Param("blogNum") int blogNum,
                                       @Param("categoryNum") int categoryNum);

}
