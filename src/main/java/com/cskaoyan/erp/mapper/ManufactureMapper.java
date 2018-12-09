package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Manufacture;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ManufactureMapper {
    @Delete({
        "delete from manufacture",
        "where manufacture_sn = #{manufactureSn,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKey(Manufacture manufacture);

    int count(Map<String, Object> map);

    List<Manufacture> selectByPage(Map<String, Object> map);

}