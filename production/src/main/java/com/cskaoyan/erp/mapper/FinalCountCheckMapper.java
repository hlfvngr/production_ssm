package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.FinalCountCheck;
import org.apache.ibatis.annotations.*;

public interface FinalCountCheckMapper {
    @Delete({
        "delete from final_count_check",
        "where f_count_check_id = #{fCountCheckId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String fCountCheckId);

    @Insert({
        "insert into final_count_check (f_count_check_id, order_id, ",
        "check_item, sample, ",
        "check_number, unqualify, ",
        "qualify, cdate, ",
        "measure_data, emp_id, ",
        "result, note)",
        "values (#{fCountCheckId,jdbcType=VARCHAR}, #{orderId,jdbcType=VARCHAR}, ",
        "#{checkItem,jdbcType=VARCHAR}, #{sample,jdbcType=INTEGER}, ",
        "#{checkNumber,jdbcType=INTEGER}, #{unqualify,jdbcType=INTEGER}, ",
        "#{qualify,jdbcType=DECIMAL}, #{cdate,jdbcType=TIMESTAMP}, ",
        "#{measureData,jdbcType=VARCHAR}, #{empId,jdbcType=VARCHAR}, ",
        "#{result,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    @Select({
        "select",
        "f_count_check_id, order_id, check_item, sample, check_number, unqualify, qualify, ",
        "cdate, measure_data, emp_id, result, note",
        "from final_count_check",
        "where f_count_check_id = #{fCountCheckId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.FinalCountCheckMapper.BaseResultMap")
    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    @Update({
        "update final_count_check",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
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
        "where f_count_check_id = #{fCountCheckId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(FinalCountCheck record);
}