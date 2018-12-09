package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Employee;
import org.apache.ibatis.annotations.*;

public interface EmployeeMapper {
    @Delete({
        "delete from employee",
        "where emp_id = #{empId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String empId);

    @Insert({
        "insert into employee (emp_id, emp_name, ",
        "sex, id_code, birthday, ",
        "join_date, status, education, ",
        "degree, major, graduate_school, ",
        "education_form, department_id)",
        "values (#{empId,jdbcType=VARCHAR}, #{empName,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=CHAR}, #{idCode,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, ",
        "#{joinDate,jdbcType=DATE}, #{status,jdbcType=VARCHAR}, #{education,jdbcType=VARCHAR}, ",
        "#{degree,jdbcType=VARCHAR}, #{major,jdbcType=VARCHAR}, #{graduateSchool,jdbcType=VARCHAR}, ",
        "#{educationForm,jdbcType=VARCHAR}, #{departmentId,jdbcType=VARCHAR})"
    })
    int insert(Employee record);

    int insertSelective(Employee record);

    @Select({
        "select",
        "emp_id, emp_name, sex, id_code, birthday, join_date, status, education, degree, ",
        "major, graduate_school, education_form, department_id",
        "from employee",
        "where emp_id = #{empId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.EmployeeMapper.BaseResultMap")
    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    @Update({
        "update employee",
        "set emp_name = #{empName,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=CHAR},",
          "id_code = #{idCode,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "join_date = #{joinDate,jdbcType=DATE},",
          "status = #{status,jdbcType=VARCHAR},",
          "education = #{education,jdbcType=VARCHAR},",
          "degree = #{degree,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "graduate_school = #{graduateSchool,jdbcType=VARCHAR},",
          "education_form = #{educationForm,jdbcType=VARCHAR},",
          "department_id = #{departmentId,jdbcType=VARCHAR}",
        "where emp_id = #{empId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Employee record);
}