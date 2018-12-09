package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.DeviceFault;
import org.apache.ibatis.annotations.*;

public interface DeviceFaultMapper {
    @Delete({
        "delete from device_fault",
        "where device_fault_id = #{deviceFaultId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceFaultId);

    @Insert({
        "insert into device_fault (device_fault_id, device_id, ",
        "device_fault_cause, device_fault_detail, ",
        "device_fault_date, device_fault_maintenance)",
        "values (#{deviceFaultId,jdbcType=VARCHAR}, #{deviceId,jdbcType=VARCHAR}, ",
        "#{deviceFaultCause,jdbcType=VARCHAR}, #{deviceFaultDetail,jdbcType=VARCHAR}, ",
        "#{deviceFaultDate,jdbcType=TIMESTAMP}, #{deviceFaultMaintenance,jdbcType=VARCHAR})"
    })
    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    @Select({
        "select",
        "device_fault_id, device_id, device_fault_cause, device_fault_detail, device_fault_date, ",
        "device_fault_maintenance",
        "from device_fault",
        "where device_fault_id = #{deviceFaultId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DeviceFaultMapper.BaseResultMap")
    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    @Update({
        "update device_fault",
        "set device_id = #{deviceId,jdbcType=VARCHAR},",
          "device_fault_cause = #{deviceFaultCause,jdbcType=VARCHAR},",
          "device_fault_detail = #{deviceFaultDetail,jdbcType=VARCHAR},",
          "device_fault_date = #{deviceFaultDate,jdbcType=TIMESTAMP},",
          "device_fault_maintenance = #{deviceFaultMaintenance,jdbcType=VARCHAR}",
        "where device_fault_id = #{deviceFaultId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DeviceFault record);
}