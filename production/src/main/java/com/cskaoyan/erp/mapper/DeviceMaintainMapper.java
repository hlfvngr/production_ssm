package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.DeviceMaintain;
import org.apache.ibatis.annotations.*;

public interface DeviceMaintainMapper {
    @Delete({
        "delete from device_maintain",
        "where device_maintain_id = #{deviceMaintainId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceMaintainId);

    @Insert({
        "insert into device_maintain (device_maintain_id, device_fault_id, ",
        "device_maintain_emp_id, device_maintain_date, ",
        "device_maintain_result, device_maintain_cost, ",
        "note)",
        "values (#{deviceMaintainId,jdbcType=VARCHAR}, #{deviceFaultId,jdbcType=VARCHAR}, ",
        "#{deviceMaintainEmpId,jdbcType=VARCHAR}, #{deviceMaintainDate,jdbcType=TIMESTAMP}, ",
        "#{deviceMaintainResult,jdbcType=VARCHAR}, #{deviceMaintainCost,jdbcType=DECIMAL}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    @Select({
        "select",
        "device_maintain_id, device_fault_id, device_maintain_emp_id, device_maintain_date, ",
        "device_maintain_result, device_maintain_cost, note",
        "from device_maintain",
        "where device_maintain_id = #{deviceMaintainId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DeviceMaintainMapper.BaseResultMap")
    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    @Update({
        "update device_maintain",
        "set device_fault_id = #{deviceFaultId,jdbcType=VARCHAR},",
          "device_maintain_emp_id = #{deviceMaintainEmpId,jdbcType=VARCHAR},",
          "device_maintain_date = #{deviceMaintainDate,jdbcType=TIMESTAMP},",
          "device_maintain_result = #{deviceMaintainResult,jdbcType=VARCHAR},",
          "device_maintain_cost = #{deviceMaintainCost,jdbcType=DECIMAL},",
          "note = #{note,jdbcType=VARCHAR}",
        "where device_maintain_id = #{deviceMaintainId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DeviceMaintain record);
}