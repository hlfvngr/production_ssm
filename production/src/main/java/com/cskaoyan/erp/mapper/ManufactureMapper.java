package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Manufacture;
import org.apache.ibatis.annotations.*;

public interface ManufactureMapper {
    @Delete({
        "delete from manufacture",
        "where manufacture_sn = #{manufactureSn,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String manufactureSn);

    @Insert({
        "insert into manufacture (manufacture_sn, order_id, ",
        "technology_id, launch_quantity, ",
        "begin_date, end_date)",
        "values (#{manufactureSn,jdbcType=VARCHAR}, #{orderId,jdbcType=VARCHAR}, ",
        "#{technologyId,jdbcType=VARCHAR}, #{launchQuantity,jdbcType=INTEGER}, ",
        "#{beginDate,jdbcType=TIMESTAMP}, #{endDate,jdbcType=TIMESTAMP})"
    })
    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    @Select({
        "select",
        "manufacture_sn, order_id, technology_id, launch_quantity, begin_date, end_date",
        "from manufacture",
        "where manufacture_sn = #{manufactureSn,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ManufactureMapper.BaseResultMap")
    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    @Update({
        "update manufacture",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "technology_id = #{technologyId,jdbcType=VARCHAR},",
          "launch_quantity = #{launchQuantity,jdbcType=INTEGER},",
          "begin_date = #{beginDate,jdbcType=TIMESTAMP},",
          "end_date = #{endDate,jdbcType=TIMESTAMP}",
        "where manufacture_sn = #{manufactureSn,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Manufacture record);
}