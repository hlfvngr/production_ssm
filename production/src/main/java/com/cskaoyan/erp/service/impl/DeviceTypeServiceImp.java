package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.mapper.DeviceTypeMapper;
import com.cskaoyan.erp.service.DeviceTypeService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeServiceImp implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper mapper;

    @Override
    public DeviceType getDeviceTypeById(String deviceTypeId) {
        return mapper.selectByPrimaryKey(deviceTypeId);
    }

    @Override
    public List<DeviceType> findPage(PageModel pageModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count=mapper.getTotalRecords();
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPage(map);
    }

    @Override
    public List<DeviceType> findPageByCondition(PageModel pageModel, DeviceType deviceType) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deviceType",deviceType);
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
    public List<DeviceType> getData() {
        return mapper.getData();
    }

    @Override
    public void insertDeviceType(DeviceType deviceType) {
        mapper.insert(deviceType);
    }

    @Override
    @Transactional
    public void deleteBatchDeviceType(String[] ids) {
        for (String id:ids
        ) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int updateDeviceType(DeviceType deviceType) {
        return mapper.updateByPrimaryKey(deviceType);
    }
}
