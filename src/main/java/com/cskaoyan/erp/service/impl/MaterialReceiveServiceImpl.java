package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.MaterialReceive;
import com.cskaoyan.erp.mapper.MaterialReceiveMapper;
import com.cskaoyan.erp.service.MaterialReceiveService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:  张娅迪
 * Date: 2018/12/08
 * Time: 上午 10:04
 * Detail requirement:
 * Method:
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("materialReceiveService")
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public Map deleteByReceiveId(String[] materialReceiveIds) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";
        Boolean flag = true;

        for (String id:materialReceiveIds ) {
            int i = materialReceiveMapper.deleteByReceiveId(id);
            if (i<=0){
                flag = false;
                break;
            }
        }

        if (flag){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Override
    public Map insert(MaterialReceive materialReceive) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialReceiveMapper.insert(materialReceive);

        if (i>0){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Override
    public Map updateByReceiveId(MaterialReceive materialReceive) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialReceiveMapper.updateByReceiveId(materialReceive);

        if (i>0){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public MaterialReceive findByReceiveId(String materialReceiveId) {
        return materialReceiveMapper.selectByReceiveId(materialReceiveId);
    }

    @Transactional(readOnly = true)
    @Override
    public Map findMaterialReceivesByPage(MaterialReceive materialReceive, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageModel pageModel = new PageModel();
        List<MaterialReceive> materialReceives = new ArrayList<>();

        map.put("materialReceive",materialReceive);

        int recordCount = materialReceiveMapper.count(map);
        if (recordCount>0){
            pageModel.setRecordCount(recordCount);

            if (page>0)
                pageModel.setPage(page);

            if (rows>0)
                pageModel.setRows(rows);

            int limitParam = pageModel.getFirstLimitParam();
            map.put("limitParam",limitParam);
            map.put("rows",rows);

            materialReceives = materialReceiveMapper.selectMaterialReceives(map);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("total",materialReceives.size());
        resultMap.put("rows",materialReceives);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer count(MaterialReceive materialReceive) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("materialReceive",materialReceive);

        Integer count = materialReceiveMapper.count(map);
        return count.intValue();
    }
}