package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Manufacture;
import com.cskaoyan.erp.mapper.ManufactureMapper;
import com.cskaoyan.erp.service.ManufactureService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    public boolean insertManufacture(Manufacture manufacture) {
       return manufactureMapper.insert(manufacture) != 0;
    }

    public List<Manufacture> findManufacture(Manufacture manufacture, PageModel pageModel) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("manufactureSn",manufacture.getManufactureSn());
        map.put("order",manufacture.getOrder());
        map.put("technology",manufacture.getTechnology());
        int count = manufactureMapper.count(map);
        if(count == 0){
            return null;
        }
        pageModel.setRecordCount(count);
        int offset = pageModel.getFirstLimitParam();
        int limit = pageModel.getRows();
        map.put("limit",limit);
        map.put("offset",offset);
        return manufactureMapper.selectByPage(map);
    }

    public boolean updateManufacture(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture) != 0;
    }

    public boolean deleteManufacture(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int ret = manufactureMapper.deleteByPrimaryKey(ids[i]);
            if(ret == 0){
                return false;
            }
        }
        return true;
    }

    public Manufacture findManufactureById(String manufactureSn) {
        return manufactureMapper.selectByPrimaryKey(manufactureSn);
    }
}
