package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.DeviceCheck;
import org.apache.ibatis.annotations.*;

public interface DeviceCheckMapper {
    @Delete({
        "delete from device_check",
        "where device_check_id = #{deviceCheckId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceCheckId);

    @Insert({
        "insert into device_check (device_check_id, device_id, ",
        "device_check_emp_id, device_check_date, ",
        "device_check_result, device_check_fault_id)",
        "values (#{deviceCheckId,jdbcType=VARCHAR}, #{deviceId,jdbcType=VARCHAR}, ",
        "#{deviceCheckEmpId,jdbcType=VARCHAR}, #{deviceCheckDate,jdbcType=TIMESTAMP}, ",
        "#{deviceCheckResult,jdbcType=VARCHAR}, #{deviceCheckFaultId,jdbcType=VARCHAR})"
    })
    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    @Select({
        "select",
        "device_check_id, device_id, device_check_emp_id, device_check_date, device_check_result, ",
        "device_check_fault_id",
        "from device_check",
        "where device_check_id = #{deviceCheckId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DeviceCheckMapper.BaseResultMap")
    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    @Update({
        "update device_check",
        "set device_id = #{deviceId,jdbcType=VARCHAR},",
          "device_check_emp_id = #{deviceCheckEmpId,jdbcType=VARCHAR},",
          "device_check_date = #{deviceCheckDate,jdbcType=TIMESTAMP},",
          "device_check_result = #{deviceCheckResult,jdbcType=VARCHAR},",
          "device_check_fault_id = #{deviceCheckFaultId,jdbcType=VARCHAR}",
        "where device_check_id = #{deviceCheckId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DeviceCheck record);
}