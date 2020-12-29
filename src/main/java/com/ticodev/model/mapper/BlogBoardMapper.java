package com.ticodev.model.mapper;

import com.ticodev.model.dto.BlogBoard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BlogBoardMapper {

    @Insert("insert into blog_board " +
            "(bg_num, ct_num, bb_subject, bb_content, bb_file) " +
            "values " +
            "(#{bgNum}, #{ctNum}, #{bbSubject}, #{bbContent}, #{bbFile})")
    int insertBoard(BlogBoard board);

}
