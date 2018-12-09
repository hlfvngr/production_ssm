package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.UnqualifyApply;
import org.apache.ibatis.annotations.*;

public interface UnqualifyApplyMapper {
    @Delete({
        "delete from unqualify_apply",
        "where unqualify_apply_id = #{unqualifyApplyId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String unqualifyApplyId);

    @Insert({
        "insert into unqualify_apply (unqualify_apply_id, product_id, ",
        "unqualify_item, unqualify_count, ",
        "assembly_date, emp_id, ",
        "apply_date, note)",
        "values (#{unqualifyApplyId,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{unqualifyItem,jdbcType=VARCHAR}, #{unqualifyCount,jdbcType=INTEGER}, ",
        "#{assemblyDate,jdbcType=TIMESTAMP}, #{empId,jdbcType=VARCHAR}, ",
        "#{applyDate,jdbcType=TIMESTAMP}, #{note,jdbcType=VARCHAR})"
    })
    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    @Select({
        "select",
        "unqualify_apply_id, product_id, unqualify_item, unqualify_count, assembly_date, ",
        "emp_id, apply_date, note",
        "from unqualify_apply",
        "where unqualify_apply_id = #{unqualifyApplyId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.UnqualifyApplyMapper.BaseResultMap")
    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    @Update({
        "update unqualify_apply",
        "set product_id = #{productId,jdbcType=VARCHAR},",
          "unqualify_item = #{unqualifyItem,jdbcType=VARCHAR},",
          "unqualify_count = #{unqualifyCount,jdbcType=INTEGER},",
          "assembly_date = #{assemblyDate,jdbcType=TIMESTAMP},",
          "emp_id = #{empId,jdbcType=VARCHAR},",
          "apply_date = #{applyDate,jdbcType=TIMESTAMP},",
          "note = #{note,jdbcType=VARCHAR}",
        "where unqualify_apply_id = #{unqualifyApplyId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UnqualifyApply record);
}