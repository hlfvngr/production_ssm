package com.cskaoyan.erp.bean.vo;

import com.cskaoyan.erp.bean.Device;

public class DeviceVo extends Device {
    String deviceTypeName;
    String deviceKeeper;

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
