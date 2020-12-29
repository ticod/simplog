package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogBoard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BlogBoardMapper {

    @Insert("insert into blog_board " +
            "(bg_num, ct_num, bb_subject, bb_content, bb_file) " +
            "values " +
            "(#{bgNum}, #{ctNum}, #{bbSubject}, #{bbContent}, #{bbFile})")
    int insertBoard(BlogBoard board);

    @Select("<script>" +
            "select " +
            "board.bb_num, board.bb_subject, board.bb_created_datetime, board.bb_hits " +
            "<if test='categoryNum == 0'>" +
                "from blog_board board where bg_num = #{blogNum}" +
            "</if>" +
            "<if test='categoryNum != 0'>" +
                "from blog_board board join blog_category_setting category " +
                "on board.ct_num = category.ct_num " +
                "where category.ct_num != 0 " +
                "and (category.ct_num = #{categoryNum} " +
                "or category.ct_parent = #{categoryNum}) " +
            "</if>" +
            "<if test='column != null'>" +
                "and board.bb_${column} like '%${find}%' " +
            "</if>" +
            "and board.bb_is_deleted != 1 " +
            "<if test='start != null'>" +
                "order by board.bb_num desc limit #{start}, #{limit}" +
            "</if>" +
            "</script>")
    List<BlogBoard> selectBoardByBlog(Map<String, Object> params);

    @Select("<script>" +
            "select count(*) " +
            "<if test='categoryNum == 0'>" +
                "from blog_board board where bg_num = #{blogNum}" +
            "</if>" +
            "<if test='categoryNum != 0'>" +
                "from blog_board board join blog_category_setting category " +
                "on board.ct_num = category.ct_num " +
                "where category.ct_num != 0 " +
                "and (category.ct_num = #{categoryNum} " +
                "or category.ct_parent = #{categoryNum}) " +
            "</if>" +
            "<if test='column != null'>" +
                "and board.bb_${column} like '%${find}%' " +
            "</if>" +
            "and board.bb_is_deleted != 1 " +
            "</script>")
    int selectBoardCountByBlog(Map<String, Object> params);

    @Select("select * from blog_board where bb_num = #{boardNum}")
    BlogBoard selectBoardByNum(int boardNum);

    @Update("update blog_board set bb_hits = bb_hits + 1 where bb_num = #{num}")
    int addHits(int num);
}
