package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.DeviceCheck;
import com.cskaoyan.erp.bean.vo.DeviceCheckVo;
import com.cskaoyan.erp.utils.PageModel;

import java.util.List;

public interface DeviceCheckService {
    List<DeviceCheckVo> findPage(PageModel pageModel);

    List<DeviceCheckVo> findPageByCondition(PageModel pageModel, DeviceCheckVo deviceCheck);

    void insertDeviceCheck(DeviceCheck deviceCheck);

    void updateDeviceCheck(DeviceCheck deviceCheck);

    void deleteBatchDeviceCheck(String[] ids);

    void updateNote(DeviceCheck deviceCheck);
}
