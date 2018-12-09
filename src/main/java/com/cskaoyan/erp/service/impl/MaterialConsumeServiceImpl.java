package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.MaterialConsume;
import com.cskaoyan.erp.mapper.MaterialConsumeMapper;
import com.cskaoyan.erp.service.MaterialConsumeService;
import com.cskaoyan.erp.utils.PageModel;
import com.mysql.cj.protocol.x.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * Date: 2018/12/06
 * Time: 下午 5:14
 * Detail requirement:
 * Method:
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("materialConsumeService")
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public Map deleteByConsumeId(String[] consumeIds) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";
        Boolean flag = true;

        for (String id:consumeIds ) {
            int i = materialConsumeMapper.deleteByConsumeId(id);
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
    public Map insert(MaterialConsume materialConsume) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialConsumeMapper.insert(materialConsume);

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
    public Map updateByConsumeId(MaterialConsume materialConsume) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialConsumeMapper.updateByConsumeId(materialConsume);

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
    public MaterialConsume findByConsumeId(String consumeId) {
        return materialConsumeMapper.selectByConsumeId(consumeId);
    }

    @Transactional(readOnly = true)
    @Override
    public Map findMaterialConsumesByPage(MaterialConsume materialConsume, Integer page , Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageModel pageModel = new PageModel();
        List<MaterialConsume> materialConsumes = new ArrayList<>();


        map.put("materialConsume",materialConsume);

        int recordCount = materialConsumeMapper.count(map);
        if (recordCount>0){
            pageModel.setRecordCount(recordCount);

            if (page>0)
                pageModel.setPage(page);

            if (rows>0)
                pageModel.setRows(rows);

            int limitParam = pageModel.getFirstLimitParam();
            map.put("limitParam",limitParam);
            map.put("rows",rows);

            materialConsumes = materialConsumeMapper.selectMaterialConsumes(map);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("total",materialConsumes.size());
        resultMap.put("rows",materialConsumes);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer count(MaterialConsume materialConsume) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("materialConsume",materialConsume);

        Integer count = materialConsumeMapper.count(map);
        return count.intValue();
    }
}