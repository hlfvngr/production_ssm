package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Work;
import org.apache.ibatis.annotations.*;

public interface WorkMapper {
    @Delete({
        "delete from work",
        "where work_id = #{workId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String workId);

    @Insert({
        "insert into work (work_id, process_number, ",
        "product_id, process_id, ",
        "device_id, rating)",
        "values (#{workId,jdbcType=VARCHAR}, #{processNumber,jdbcType=VARCHAR}, ",
        "#{productId,jdbcType=VARCHAR}, #{processId,jdbcType=VARCHAR}, ",
        "#{deviceId,jdbcType=VARCHAR}, #{rating,jdbcType=INTEGER})"
    })
    int insert(Work record);

    int insertSelective(Work record);

    @Select({
        "select",
        "work_id, process_number, product_id, process_id, device_id, rating",
        "from work",
        "where work_id = #{workId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.WorkMapper.BaseResultMap")
    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    @Update({
        "update work",
        "set process_number = #{processNumber,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "process_id = #{processId,jdbcType=VARCHAR},",
          "device_id = #{deviceId,jdbcType=VARCHAR},",
          "rating = #{rating,jdbcType=INTEGER}",
        "where work_id = #{workId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Work record);
}