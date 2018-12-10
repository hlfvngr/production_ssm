package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Manufacture;
import org.apache.ibatis.annotations.*;


import java.util.List;
import java.util.Map;

public interface ManufactureMapper {

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);



    int count(Map<String, Object> map);

    List<Manufacture> selectByPage(Map<String, Object> map);

}