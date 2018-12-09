package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Material;

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
public interface MaterialService {
    Map deleteByMaterialId(String[] materialIds);

    Map insert(Material material);

    //改
    Map updateByMaterialId(Material material);

    //查
    Material findByMaterialId(String materialId);

    Map findMaterialsByPage(Material material, Integer page , Integer rows);

    Integer count(Material material);

    List findMaterials();
}
