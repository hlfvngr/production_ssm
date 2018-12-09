package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.ProcessCountCheck;
import org.apache.ibatis.annotations.*;

public interface ProcessCountCheckMapper {
    @Delete({
        "delete from process_count_check",
        "where p_count_check_id = #{pCountCheckId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String pCountCheckId);

    @Insert({
        "insert into process_count_check (p_count_check_id, process_id, ",
        "check_item, sample, ",
        "check_number, unqualify, ",
        "qualify, cdate, ",
        "measure_data, emp_id, ",
        "result, note)",
        "values (#{pCountCheckId,jdbcType=VARCHAR}, #{processId,jdbcType=VARCHAR}, ",
        "#{checkItem,jdbcType=VARCHAR}, #{sample,jdbcType=INTEGER}, ",
        "#{checkNumber,jdbcType=INTEGER}, #{unqualify,jdbcType=INTEGER}, ",
        "#{qualify,jdbcType=DECIMAL}, #{cdate,jdbcType=TIMESTAMP}, ",
        "#{measureData,jdbcType=VARCHAR}, #{empId,jdbcType=VARCHAR}, ",
        "#{result,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    @Select({
        "select",
        "p_count_check_id, process_id, check_item, sample, check_number, unqualify, qualify, ",
        "cdate, measure_data, emp_id, result, note",
        "from process_count_check",
        "where p_count_check_id = #{pCountCheckId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessCountCheckMapper.BaseResultMap")
    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    @Update({
        "update process_count_check",
        "set process_id = #{processId,jdbcType=VARCHAR},",
          "check_item = #{checkItem,jdbcType=VARCHAR},",
          "sample = #{sample,jdbcType=INTEGER},",
          "check_number = #{checkNumber,jdbcType=INTEGER},",
          "unqualify = #{unqualify,jdbcType=INTEGER},",
          "qualify = #{qualify,jdbcType=DECIMAL},",
          "cdate = #{cdate,jdbcType=TIMESTAMP},",
          "measure_data = #{measureData,jdbcType=VARCHAR},",
          "emp_id = #{empId,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where p_count_check_id = #{pCountCheckId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProcessCountCheck record);
}