package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Material;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MaterialMapper {

    int deleteByMaterialId(String materialId);

    int insert(Material material);

    Material selectByMaterialId(String materialId);

    List<Material> selectMaterials(@Param("params") Map<String, Object> params);

    Integer count(@Param("params") Map<String, Object> params);

    int updateByMaterialId(Material material);

}