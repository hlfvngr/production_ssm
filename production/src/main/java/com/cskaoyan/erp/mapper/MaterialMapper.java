package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Material;
import org.apache.ibatis.annotations.*;

public interface MaterialMapper {
    @Delete({
        "delete from material",
        "where material_id = #{materialId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String materialId);

    @Insert({
        "insert into material (material_id, material_type, ",
        "status, remaining, ",
        "note)",
        "values (#{materialId,jdbcType=VARCHAR}, #{materialType,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{remaining,jdbcType=INTEGER}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Material record);

    int insertSelective(Material record);

    @Select({
        "select",
        "material_id, material_type, status, remaining, note",
        "from material",
        "where material_id = #{materialId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.MaterialMapper.BaseResultMap")
    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    @Update({
        "update material",
        "set material_type = #{materialType,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "remaining = #{remaining,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where material_id = #{materialId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Material record);
}