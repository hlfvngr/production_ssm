package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.DeviceMaintain;
import com.cskaoyan.erp.bean.vo.DeviceMaintainVo;
import com.cskaoyan.erp.utils.PageModel;

import java.util.List;

public interface DeviceMaintainService {
    List<DeviceMaintainVo> findPage(PageModel pageModel);

    List<DeviceMaintainVo> findPageByCondition(PageModel pageModel, DeviceMaintainVo deviceMaintain);

    void insertDeviceMaintain(DeviceMaintain deviceMaintain);

    void updateDeviceMaintain(DeviceMaintain deviceMaintain);

    void deleteBatchDeviceMaintain(String[] ids);

    void updateNote(DeviceMaintain deviceMaintain);
}
