package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.DeviceType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeviceTypeMapper {
    @Delete({
        "delete from device_type",
        "where device_type_id = #{deviceTypeId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deviceTypeId);

    @Insert({
        "insert into device_type (device_type_id, device_type_name, ",
        "device_type_model, device_type_spec, ",
        "device_type_supplier, device_type_producer, ",
        "device_type_quantity, device_type_warranty)",
        "values (#{deviceTypeId,jdbcType=VARCHAR}, #{deviceTypeName,jdbcType=VARCHAR}, ",
        "#{deviceTypeModel,jdbcType=VARCHAR}, #{deviceTypeSpec,jdbcType=VARCHAR}, ",
        "#{deviceTypeSupplier,jdbcType=VARCHAR}, #{deviceTypeProducer,jdbcType=VARCHAR}, ",
        "#{deviceTypeQuantity,jdbcType=INTEGER}, #{deviceTypeWarranty,jdbcType=TIMESTAMP})"
    })
    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    @Select({
        "select",
        "device_type_id, device_type_name, device_type_model, device_type_spec, device_type_supplier, ",
        "device_type_producer, device_type_quantity, device_type_warranty",
        "from device_type",
        "where device_type_id = #{deviceTypeId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.DeviceTypeMapper.BaseResultMap")
    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    @Update({
        "update device_type",
        "set device_type_name = #{deviceTypeName,jdbcType=VARCHAR},",
          "device_type_model = #{deviceTypeModel,jdbcType=VARCHAR},",
          "device_type_spec = #{deviceTypeSpec,jdbcType=VARCHAR},",
          "device_type_supplier = #{deviceTypeSupplier,jdbcType=VARCHAR},",
          "device_type_producer = #{deviceTypeProducer,jdbcType=VARCHAR},",
          "device_type_quantity = #{deviceTypeQuantity,jdbcType=INTEGER},",
          "device_type_warranty = #{deviceTypeWarranty,jdbcType=TIMESTAMP}",
        "where device_type_id = #{deviceTypeId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DeviceType record);

    Integer getTotalRecords();

    List<DeviceType> findPage(Map<String, Object> map);

    Integer getConditionCount(Map<String, Object> map);

    List<DeviceType> findPageByCondition(Map<String, Object> map);

    List<DeviceType> getData();
}