package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface WorkMapper {
    @Delete({
        "delete from work",
        "where work_id = #{workId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String workId);

    int insert(Work work);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKey(Work work);

    int count(Map<String, Object> map);

    List<Work> selectByPage(Map<String, Object> map);

    List<Work> selectAllWork();

}