package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Department;
import org.apache.ibatis.annotations.*;

public interface DepartmentMapper {
    @Delete({
        "delete from department",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String departmentId);

    @Insert({
        "insert into department (department_id, department_name, ",
        "note)",
        "values (#{departmentId,jdbcType=VARCHAR}, #{departmentName,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Department record);

    int insertSelective(Department record);

    @Select({
        "select",
        "department_id, department_name, note",
        "from department",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DepartmentMapper.BaseResultMap")
    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update department",
        "set department_name = #{departmentName,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Department record);
}