package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.DeviceMaintain;
import com.cskaoyan.erp.bean.vo.DeviceMaintainVo;
import com.cskaoyan.erp.mapper.DeviceMaintainMapper;
import com.cskaoyan.erp.service.DeviceMaintainService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceMaintainServiceImp implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper mapper;

    @Override
    public List<DeviceMaintainVo> findPage(PageModel pageModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count=mapper.getTotalRecords();
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPage(map);
    }

    @Override
    public List<DeviceMaintainVo> findPageByCondition(PageModel pageModel, DeviceMaintainVo deviceMaintain) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deviceMaintain",deviceMaintain);
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
    public void insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        mapper.insert(deviceMaintain);
    }

    @Override
    public void updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        mapper.updateByPrimaryKey(deviceMaintain);
    }

    @Override
    public void deleteBatchDeviceMaintain(String[] ids) {
        for (String id:ids
        ) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void updateNote(DeviceMaintain deviceMaintain) {
        mapper.updateByPrimaryKeySelective(deviceMaintain);
    }
}
