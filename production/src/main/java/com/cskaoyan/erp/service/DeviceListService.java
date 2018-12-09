package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.utils.PageModel;

import java.util.List;

public interface DeviceListService {

    List<DeviceVo> findPage(PageModel pageModel);


    public Device getDeviceById(String deviceId);

    List<DeviceVo> findPageByCondition(PageModel pageModel, Device device);

    void insertDevice(Device device);

    void updateDevice(Device device);

    void deleteBatchDevice(String[] ids);

    List<Device> getData();


    void updateNote(Device device);
}
