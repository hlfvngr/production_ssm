package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.mapper.DeviceMapper;
import com.cskaoyan.erp.service.DeviceListService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceListServiceImp implements DeviceListService {

    @Autowired
    DeviceMapper mapper;

    public List<DeviceVo> findPage(PageModel pageModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count=mapper.getTotalRecords();
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPage(map);
    }

    public Device getDeviceById(String deviceId) {
        return mapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public void insertDevice(Device device) {
        mapper.insert(device);
    }

    @Override
    public void updateDevice(Device device) {
        mapper.updateByPrimaryKey(device);
    }

    @Override
    @Transactional
    public void deleteBatchDevice(String[] ids) {
        for (String id:ids
             ) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<DeviceVo> findPageByCondition(PageModel pageModel, Device device) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("device",device);
        Integer count=mapper.getConditionCount(map);
        if (count == 0) {
            return null;
        }
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPageByCondition(map);
    }

    @Override
    public List<Device> getData() {
        return mapper.getData();
    }

    @Override
    public void updateNote(Device device) {
        mapper.updateByPrimaryKeySelective(device);
    }
}
