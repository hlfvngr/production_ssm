package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.MaterialReceive;
import org.apache.ibatis.annotations.*;

public interface MaterialReceiveMapper {
    @Delete({
        "delete from material_receive",
        "where receive_id = #{receiveId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String receiveId);

    @Insert({
        "insert into material_receive (receive_id, material_id, ",
        "amount, receive_date, ",
        "sender, receiver, ",
        "note)",
        "values (#{receiveId,jdbcType=VARCHAR}, #{materialId,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=INTEGER}, #{receiveDate,jdbcType=TIMESTAMP}, ",
        "#{sender,jdbcType=VARCHAR}, #{receiver,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    @Select({
        "select",
        "receive_id, material_id, amount, receive_date, sender, receiver, note",
        "from material_receive",
        "where receive_id = #{receiveId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.MaterialReceiveMapper.BaseResultMap")
    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    @Update({
        "update material_receive",
        "set material_id = #{materialId,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=INTEGER},",
          "receive_date = #{receiveDate,jdbcType=TIMESTAMP},",
          "sender = #{sender,jdbcType=VARCHAR},",
          "receiver = #{receiver,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where receive_id = #{receiveId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MaterialReceive record);
}