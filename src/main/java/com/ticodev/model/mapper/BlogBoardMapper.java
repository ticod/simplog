package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogBoard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BlogBoardMapper {

    @Insert("insert into blog_board " +
            "(bg_num, ct_num, bb_subject, bb_content, bb_file) " +
            "values " +
            "(#{bgNum}, #{ctNum}, #{bbSubject}, #{bbContent}, #{bbFile})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "bbNum",
            before = false, resultType = int.class)
    int insertBoard(BlogBoard board);

    @Select("<script>" +
            "select " +
            "board.bb_num, board.bb_subject, board.bb_created_datetime, board.bb_hits " +
            "<if test='categoryNum == 0'>" +
                "from blog_board board where " +
                "<if test='blogNum != null'>" +
                    "bg_num = #{blogNum} " +
                "</if>" +
                "<if test='blogNum == null'>" +
                    "0 = 0 " +
                "</if>" +
            "</if>" +
            "<if test='categoryNum != 0'>" +
                "from blog_board board join blog_category_setting category " +
                "on board.ct_num = category.ct_num " +
                "where category.ct_num != 0 " +
                "and (category.ct_num = #{categoryNum} " +
                "or category.ct_parent = #{categoryNum}) " +
            "</if>" +
            "<if test='columns != null'>" +
                "and " +
                "<foreach collection='columns' item='column' separator='or '>" +
                    "board.bb_${column} like '%${find}%' " +
                "</foreach>" +
            "</if>" +
            // 블로그 분야 검색 여부
            "<if test='blogTypes != null'>" +
                "and bt_type in " +
                "<foreach collection='blogTypes' item='blogType' open='(' separator=',' close=')'>" +
                    "#{blogType}" +
                "</foreach>" +
            "</if>" +
            "and board.bb_is_deleted != 1 " +
            "<if test='start != null'>" +
                "order by board.bb_num desc limit #{start}, #{limit}" +
            "</if>" +
            "</script>")
    List<BlogBoard> selectBoardByBlog(Map<String, Object> params);

    @Select("<script>" +
            "select count(*) " +
            // 카테고리 번호 여부. 없으면 그냥 가져옴
            "<if test='categoryNum == 0'>" +
                "from blog_board board where " +
            // 블로그 번호 여부 없으면 항상 참
                "<if test='blogNum != null'>" +
                    "bg_num = #{blogNum} " +
                "</if>" +
                "<if test='blogNum == null'>" +
                    "0 = 0 " +
                "</if>" +
            "</if>" +
            // 카테고리 번호가 있으면 join 활용해서 하위 카테고리까지 탐색
            "<if test='categoryNum != 0'>" +
                "from blog_board board join blog_category_setting category " +
                "on board.ct_num = category.ct_num " +
                "where category.ct_num != 0 " +
                "and (category.ct_num = #{categoryNum} " +
                "or category.ct_parent = #{categoryNum}) " +
            "</if>" +
            // 검색 여부
            "<if test='columns != null'>" +
                "and " +
                "<foreach collection='columns' item='column' separator='or '>" +
                    "board.bb_${column} like '%${find}%' " +
                "</foreach>" +
            "</if>" +
            // 블로그 분야 검색 여부
            "<if test='blogTypes != null'>" +
                "and bt_type in " +
                "<foreach collection='blogTypes' item='blogType' open='(' separator=',' close=')'>" +
                    "#{blogType}" +
                "</foreach>" +
            "</if>" +
            // 삭제 안된 게시글만 가져옴
            "and board.bb_is_deleted != 1 " +
            "</script>")
    int selectBoardCountByBlog(Map<String, Object> params);

    @Select("select * from blog_board where bb_num = #{boardNum}")
    BlogBoard selectBoardByNum(int boardNum);

    @Update("update blog_board set bb_hits = bb_hits + 1 where bb_num = #{num}")
    int addHits(int num);

    @Update("update blog_board " +
            "set " +
            "ct_num = #{ctNum}, " +
            "bb_subject = #{bbSubject}, " +
            "bb_content = #{bbContent}, " +
            "bb_file = #{bbFile} " +
            "where bb_num = #{bbNum}")
    int updateBoard(BlogBoard board);

    @Update("update blog_board " +
            "set " +
            "bb_is_deleted = 1 " +
            "where bb_num = #{bbNum}")
    int deleteBoardByNum(int num);
}
