package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.FinalMeasureCheck;
import org.apache.ibatis.annotations.*;

public interface FinalMeasureCheckMapper {
    @Delete({
        "delete from final_measuret_check",
        "where f_measure_check_id = #{fMeasureCheckId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String fMeasureCheckId);

    @Insert({
        "insert into final_measuret_check (f_measure_check_id, order_id, ",
        "check_item, cdate, ",
        "measure_data, emp_id, ",
        "result, note)",
        "values (#{fMeasureCheckId,jdbcType=VARCHAR}, #{orderId,jdbcType=VARCHAR}, ",
        "#{checkItem,jdbcType=VARCHAR}, #{cdate,jdbcType=TIMESTAMP}, ",
        "#{measureData,jdbcType=VARCHAR}, #{empId,jdbcType=VARCHAR}, ",
        "#{result,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(FinalMeasureCheck record);

    int insertSelective(FinalMeasureCheck record);

    @Select({
        "select",
        "f_measure_check_id, order_id, check_item, cdate, measure_data, emp_id, result, ",
        "note",
        "from final_measuret_check",
        "where f_measure_check_id = #{fMeasureCheckId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.FinalMeasureCheckMapper.BaseResultMap")
    FinalMeasureCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasureCheck record);

    @Update({
        "update final_measuret_check",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "check_item = #{checkItem,jdbcType=VARCHAR},",
          "cdate = #{cdate,jdbcType=TIMESTAMP},",
          "measure_data = #{measureData,jdbcType=VARCHAR},",
          "emp_id = #{empId,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where f_measure_check_id = #{fMeasureCheckId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(FinalMeasureCheck record);
}