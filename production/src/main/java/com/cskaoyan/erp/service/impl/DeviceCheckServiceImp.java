package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.DeviceCheck;
import com.cskaoyan.erp.bean.vo.DeviceCheckVo;
import com.cskaoyan.erp.mapper.DeviceCheckMapper;
import com.cskaoyan.erp.service.DeviceCheckService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceCheckServiceImp implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper mapper;

    @Override
    public List<DeviceCheckVo> findPage(PageModel pageModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count=mapper.getTotalRecords();
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPage(map);
    }

    @Override
    public List<DeviceCheckVo> findPageByCondition(PageModel pageModel, DeviceCheckVo deviceCheck) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deviceCheck",deviceCheck);
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
    public void insertDeviceCheck(DeviceCheck deviceCheck) {
        mapper.insert(deviceCheck);
    }

    @Override
    public void updateDeviceCheck(DeviceCheck deviceCheck) {
        mapper.updateByPrimaryKey(deviceCheck);
    }

    @Override
    public void deleteBatchDeviceCheck(String[] ids) {
        for (String id:ids
        ) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void updateNote(DeviceCheck deviceCheck) {
        mapper.updateByPrimaryKeySelective(deviceCheck);
    }
}
