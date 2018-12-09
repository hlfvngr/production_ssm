package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.*;

public interface ProcessMeasureCheckMapper {
    @Delete({
        "delete from process_measure_check",
        "where p_measure_check_id = #{pMeasureCheckId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String pMeasureCheckId);

    @Insert({
        "insert into process_measure_check (p_measure_check_id, process_id, ",
        "check_item, cdate, ",
        "measure_data, emp_id, ",
        "result, note)",
        "values (#{pMeasureCheckId,jdbcType=VARCHAR}, #{processId,jdbcType=VARCHAR}, ",
        "#{checkItem,jdbcType=VARCHAR}, #{cdate,jdbcType=TIMESTAMP}, ",
        "#{measureData,jdbcType=VARCHAR}, #{empId,jdbcType=VARCHAR}, ",
        "#{result,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    @Select({
        "select",
        "p_measure_check_id, process_id, check_item, cdate, measure_data, emp_id, result, ",
        "note",
        "from process_measure_check",
        "where p_measure_check_id = #{pMeasureCheckId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMeasureCheckMapper.BaseResultMap")
    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    @Update({
        "update process_measure_check",
        "set process_id = #{processId,jdbcType=VARCHAR},",
          "check_item = #{checkItem,jdbcType=VARCHAR},",
          "cdate = #{cdate,jdbcType=TIMESTAMP},",
          "measure_data = #{measureData,jdbcType=VARCHAR},",
          "emp_id = #{empId,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where p_measure_check_id = #{pMeasureCheckId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProcessMeasureCheck record);
}