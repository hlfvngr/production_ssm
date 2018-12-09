package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Customer;
import org.apache.ibatis.annotations.*;

public interface CustomerMapper {
    @Delete({
        "delete from custom",
        "where custom_id = #{customId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String customId);

    @Insert({
        "insert into custom (custom_id, custom_name, ",
        "full_name, address, ",
        "fax, email, owner_name, ",
        "owner_tel, status, ",
        "note)",
        "values (#{customId,jdbcType=VARCHAR}, #{customName,jdbcType=VARCHAR}, ",
        "#{fullName,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{fax,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{ownerName,jdbcType=VARCHAR}, ",
        "#{ownerTel,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Customer record);

    int insertSelective(Customer record);

    @Select({
        "select",
        "custom_id, custom_name, full_name, address, fax, email, owner_name, owner_tel, ",
        "status, note",
        "from custom",
        "where custom_id = #{customId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.CustomerMapper.BaseResultMap")
    Customer selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update custom",
        "set custom_name = #{customName,jdbcType=VARCHAR},",
          "full_name = #{fullName,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "fax = #{fax,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "owner_name = #{ownerName,jdbcType=VARCHAR},",
          "owner_tel = #{ownerTel,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where custom_id = #{customId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Customer record);
}