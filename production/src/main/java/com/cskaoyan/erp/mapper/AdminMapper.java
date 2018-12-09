package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Admin;
import org.apache.ibatis.annotations.*;

public interface AdminMapper {
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_user (id, username, ",
        "password, locked)",
        "values (#{id,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{locked,jdbcType=CHAR})"
    })
    int insert(Admin record);

    int insertSelective(Admin record);

    @Select({
        "select",
        "id, username, password, locked",
        "from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.AdminMapper.BaseResultMap")
    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update sys_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "locked = #{locked,jdbcType=CHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Admin record);
}