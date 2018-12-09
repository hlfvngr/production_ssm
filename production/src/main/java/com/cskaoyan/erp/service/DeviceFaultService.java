package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.DeviceFault;
import com.cskaoyan.erp.bean.vo.DeviceFaultVo;
import com.cskaoyan.erp.utils.PageModel;

import java.util.List;

public interface DeviceFaultService {
    List<DeviceFaultVo> findPage(PageModel pageModel);

    List<DeviceFaultVo> findPageByCondition(PageModel pageModel, DeviceFaultVo deviceFault);

    void insertDeviceFault(DeviceFault deviceFault);

    void updateDeviceFault(DeviceFault deviceFault);

    void deleteBatchDeviceFault(String[] ids);

    DeviceFault getDeviceFault(String deviceFaultId);

    DeviceFault getData();

    void updateNote(DeviceFault deviceFault);
}
