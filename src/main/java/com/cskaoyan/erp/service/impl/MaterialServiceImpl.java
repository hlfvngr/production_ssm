package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Material;
import com.cskaoyan.erp.mapper.MaterialMapper;
import com.cskaoyan.erp.service.MaterialService;
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
 * Date: 2018/12/07
 * Time: 下午 11:58
 * Detail requirement:
 * Method:
 */

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public Map deleteByMaterialId(String[] materialIds) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";
        Boolean flag = true;

        for (String id:materialIds ) {
            int i = materialMapper.deleteByMaterialId(id);
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
    public Map insert(Material material) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialMapper.insert(material);

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
    public Map updateByMaterialId(Material material) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = materialMapper.updateByMaterialId(material);

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
    public Material findByMaterialId(String materialId) {
        return materialMapper.selectByMaterialId(materialId);
    }

    @Transactional(readOnly = true)
    @Override
    public Map findMaterialsByPage(Material material, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageModel pageModel = new PageModel();
        List<Material> materials = new ArrayList<>();

        map.put("material",material);

        int recordCount = materialMapper.count(map);
        if (recordCount>0){
            pageModel.setRecordCount(recordCount);

            if (page>0)
                pageModel.setPage(page);

            if (rows>0)
                pageModel.setRows(rows);

            int limitParam = pageModel.getFirstLimitParam();
            map.put("limitParam",limitParam);
            map.put("rows",rows);

            materials = materialMapper.selectMaterials(map);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("total",materials.size());
        resultMap.put("rows",materials);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer count(Material material) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("material",material);

        Integer count = materialMapper.count(map);
        return count.intValue();
    }

    @Transactional(readOnly = true)
    @Override
    public List findMaterials() {
        return materialMapper.selectMaterials(new HashMap<>());
    }
}