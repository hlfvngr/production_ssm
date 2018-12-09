package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.MaterialConsume;
import com.cskaoyan.erp.utils.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MaterialConsumeMapper {

    int deleteByConsumeId(String consumeId);

    int insert(MaterialConsume materialConsume);

    //改
    int updateByConsumeId(MaterialConsume materialConsume);

    //查
    MaterialConsume selectByConsumeId(String consumeId);

    List<MaterialConsume> selectMaterialConsumes(@Param("params") Map<String, Object> params);

    Integer count(@Param("params") Map<String, Object> params);
}