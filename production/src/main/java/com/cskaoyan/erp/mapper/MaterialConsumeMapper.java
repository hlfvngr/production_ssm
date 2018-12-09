package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.MaterialConsume;
import org.apache.ibatis.annotations.*;

public interface MaterialConsumeMapper {
    @Delete({
        "delete from material_consume",
        "where consume_id = #{consumeId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String consumeId);

    @Insert({
        "insert into material_consume (consume_id, work_id, ",
        "material_id, consume_amount, ",
        "consume_date, sender, ",
        "receiver, note)",
        "values (#{consumeId,jdbcType=VARCHAR}, #{workId,jdbcType=VARCHAR}, ",
        "#{materialId,jdbcType=VARCHAR}, #{consumeAmount,jdbcType=INTEGER}, ",
        "#{consumeDate,jdbcType=TIMESTAMP}, #{sender,jdbcType=VARCHAR}, ",
        "#{receiver,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    @Select({
        "select",
        "consume_id, work_id, material_id, consume_amount, consume_date, sender, receiver, ",
        "note",
        "from material_consume",
        "where consume_id = #{consumeId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.MaterialConsumeMapper.BaseResultMap")
    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    @Update({
        "update material_consume",
        "set work_id = #{workId,jdbcType=VARCHAR},",
          "material_id = #{materialId,jdbcType=VARCHAR},",
          "consume_amount = #{consumeAmount,jdbcType=INTEGER},",
          "consume_date = #{consumeDate,jdbcType=TIMESTAMP},",
          "sender = #{sender,jdbcType=VARCHAR},",
          "receiver = #{receiver,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where consume_id = #{consumeId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MaterialConsume record);
}