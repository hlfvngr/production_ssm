package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.utils.PageModel;

import java.util.List;

public interface DeviceTypeService {

    DeviceType getDeviceTypeById(String deviceTypeId);

    int updateDeviceType(DeviceType deviceType);

    List<DeviceType> findPage(PageModel pageModel);

    List<DeviceType> findPageByCondition(PageModel pageModel, DeviceType deviceType);

    List<DeviceType> getData();

    void insertDeviceType(DeviceType deviceType);

    void deleteBatchDeviceType(String[] ids);
}
