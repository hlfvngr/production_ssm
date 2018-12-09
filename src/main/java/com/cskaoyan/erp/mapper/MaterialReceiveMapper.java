package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Material;
import com.cskaoyan.erp.bean.MaterialReceive;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MaterialReceiveMapper {

    int deleteByReceiveId(String receiveId);

    int insert(MaterialReceive record);

    int updateByReceiveId(MaterialReceive record);

    MaterialReceive selectByReceiveId(String receiveId);

    List<MaterialReceive> selectMaterialReceives(@Param("params") Map<String, Object> params);


    Integer count(@Param("params") Map<String, Object> params);

}