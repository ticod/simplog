package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BlogDataMapper {

    @Select("select * from blog_data " +
            "where bg_num = #{blogNum} " +
            "and date_sub(now(), interval #{term} day) < now()" +
            "order by bd_date desc")
    List<BlogData> selectBlogDataByBlogAndTerm(int blogNum, int term);

    @Select("select * from blog_data where bg_num = #{blogNum} and bd_date = #{formattedDate}")
    BlogData selectByBlogAndDate(@Param("blogNum") int blogNum,
                                 @Param("formattedDate") String formattedDate);

    @Insert("insert into blog_data " +
            "(bg_num, bd_date, bd_hits) " +
            "values " +
            "(#{blogNum}, current_date, 1)")
    int initDataBlog(int blogNum);

    @Update("update blog_data set " +
            "bd_hits = bd_hits + 1 " +
            "where " +
            "bg_num = #{blogNum} " +
            "and bd_date = CURRENT_DATE")
    int addHitsBlog(int blogNum);


}
