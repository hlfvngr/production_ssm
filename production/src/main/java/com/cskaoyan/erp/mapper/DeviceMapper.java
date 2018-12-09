package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeviceMapper {

    List<DeviceVo> findPage(Map<String, Object> map);


    @Delete({
        "delete from device",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceId);

    @Insert({
        "insert into device (device_id, device_name, ",
        "device_type_id, device_status_id, ",
        "device_status, device_purchase_date, ",
        "device_purchase_price, device_manufacture_date, ",
        "device_service_life, device_keeper_id, ",
        "note)",
        "values (#{deviceId,jdbcType=VARCHAR}, #{deviceName,jdbcType=VARCHAR}, ",
        "#{deviceTypeId,jdbcType=VARCHAR}, #{deviceStatusId,jdbcType=VARCHAR}, ",
        "#{deviceStatus,jdbcType=VARCHAR}, #{devicePurchaseDate}, ",
        "#{devicePurchasePrice,jdbcType=DECIMAL}, #{deviceManufactureDate}, ",
        "#{deviceServiceLife}, #{deviceKeeperId,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Device record);

    int insertSelective(Device record);

    @Select({
        "select",
        "device_id, device_name, device_type_id, device_status_id, device_status, device_purchase_date, ",
        "device_purchase_price, device_manufacture_date, device_service_life, device_keeper_id, ",
        "note",
        "from device",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DeviceMapper.BaseResultMap")
    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    @Update({
        "update device",
        "set device_name = #{deviceName,jdbcType=VARCHAR},",
          "device_type_id = #{deviceTypeId,jdbcType=VARCHAR},",
          "device_status_id = #{deviceStatusId,jdbcType=VARCHAR},",
          "device_status = #{deviceStatus,jdbcType=VARCHAR},",
          "device_purchase_date = #{devicePurchaseDate,jdbcType=TIMESTAMP},",
          "device_purchase_price = #{devicePurchasePrice,jdbcType=DECIMAL},",
          "device_manufacture_date = #{deviceManufactureDate,jdbcType=TIMESTAMP},",
          "device_service_life = #{deviceServiceLife,jdbcType=TIMESTAMP},",
          "device_keeper_id = #{deviceKeeperId,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where device_id = #{deviceId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Device record);


    Integer getTotalRecords();

    List<DeviceVo> findPageByCondition(Map<String, Object> map);

    Integer getConditionCount(Map<String, Object> map);

    List<Device> getData();

}