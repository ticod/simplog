package com.ticodev.model.mapper;

import com.ticodev.model.dto.PlatformData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface PlatformDataMapper {

    @Select("select * from platform_data " +
            "where date_sub(now(), interval #{term} day) < now() " +
            "order by bp_date desc")
    List<PlatformData> selectByTerm(int term);

    @Select("select * from platform_data where bp_date = #{date}")
    PlatformData selectByDate(String formattedDate);

    @Insert("insert into platform_data " +
            "(bp_date, bp_hits) " +
            "values " +
            "(current_date, 1)")
    int initData();

    @Update("update platform_data set " +
            "bp_hits = bp_hits + 1 " +
            "where " +
            "bp_date = CURRENT_DATE")
    int addHits();

}
