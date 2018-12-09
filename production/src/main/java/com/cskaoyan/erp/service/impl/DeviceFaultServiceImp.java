package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.DeviceFault;
import com.cskaoyan.erp.bean.vo.DeviceFaultVo;
import com.cskaoyan.erp.mapper.DeviceFaultMapper;
import com.cskaoyan.erp.service.DeviceFaultService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceFaultServiceImp implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper mapper;

    @Override
    public List<DeviceFaultVo> findPage(PageModel pageModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count=mapper.getTotalRecords();
        pageModel.setRecordCount(count);
        map.put("limit", pageModel.getRows());
        map.put("offset", pageModel.getFirstLimitParam());
        return mapper.findPage(map);
    }

    @Override
    public List<DeviceFaultVo> findPageByCondition(PageModel pageModel, DeviceFaultVo deviceFault) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deviceFault",deviceFault);
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
    public void insertDeviceFault(DeviceFault deviceFault) {
        mapper.insert(deviceFault);
    }

    @Override
    public void updateDeviceFault(DeviceFault deviceFault) {
        mapper.updateByPrimaryKey(deviceFault);
    }

    @Override
    @Transactional
    public void deleteBatchDeviceFault(String[] ids) {
        for (String id:ids
        ) {
            mapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public DeviceFault getDeviceFault(String deviceFaultId) {
        return mapper.selectByPrimaryKey(deviceFaultId);
    }

    @Override
    public DeviceFault getData() {
        return mapper.getData();
    }

    @Override
    public void updateNote(DeviceFault deviceFault) {
        mapper.updateByPrimaryKeySelective(deviceFault);
    }
}
