package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.TechnologyRequirement;
import com.cskaoyan.erp.bean.VO.TechnologyRequirementVO;
import com.cskaoyan.erp.util.PageModel;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.Past;
import java.util.List;

public interface TechnologyRequirementMapper {


    @Insert({
        "insert into technology_requirement (technology_requirement_id, technology_id, ",
        "requirement, add_time, ",
        "revise_time)",
        "values (#{technologyRequirementId,jdbcType=VARCHAR}, #{technologyId,jdbcType=VARCHAR}, ",
        "#{requirement,jdbcType=VARCHAR}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{reviseTime,jdbcType=TIMESTAMP})"
    })
    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    @Select({
        "select",
        "technology_requirement_id, technology_id, requirement, add_time, revise_time",
        "from technology_requirement",
        "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.BaseResultMap")
    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);




    /**工艺需求*/


    /**显示*/
    @Select("select count(*) from technology_requirement")
    public Integer requirementCount();

    @Select({
            "select",
            "technology_requirement_id, req.technology_id, requirement, add_time, revise_time,technology_name",
            "from technology_requirement as req left join technology on req.technology_id=technology.technology_id",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.ResultMap")
    public List<TechnologyRequirementVO> selectRequirementList(@Param("pageModel") PageModel pageModel);


    /**搜索*/
    @Select({
            "select",
            "technology_requirement_id, req.technology_id, requirement, add_time, revise_time,technology_name",
            "from technology_requirement as req left join technology on req.technology_id=technology.technology_id",
            "where technology_requirement_id LIKE CONCAT ('%',#{requirementId,jdbcType=VARCHAR},'%')"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.ResultMap")
    List<TechnologyRequirementVO> searchByRequirementId(@Param("requirementId") String requirementId);

    @Select({
            "select",
            "technology_requirement_id, req.technology_id, requirement, add_time, revise_time,technology_name",
            "from technology_requirement as req left join technology on req.technology_id=technology.technology_id",
            "where technology_requirement_id LIKE CONCAT ('%',#{requirementId,jdbcType=VARCHAR},'%')",
            "limit #{pageModel.firstLimitParam} , #{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.ResultMap")
    List<TechnologyRequirementVO> searchPageByRequirementId(@Param("requirementId") String requirementId,
                                    @Param("pageModel")PageModel pageModel);


    @Select({
            "select",
            "technology_requirement_id, req.technology_id, requirement, add_time, revise_time,technology_name",
            "from technology_requirement as req left join technology on req.technology_id=technology.technology_id",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%')"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.ResultMap")
    List<TechnologyRequirementVO> searchByTechnologyName(@Param("technologyName")String technologyName);


    @Select({
            "select",
            "technology_requirement_id, req.technology_id, requirement, add_time, revise_time,technology_name",
            "from technology_requirement as req left join technology on req.technology_id=technology.technology_id",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%') ",
            "limit #{pageModel.firstLimitParam} , #{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.ResultMap")
    List<TechnologyRequirementVO> searchPageByTechnologyName(@Param("technologyName") String technologyName,
                                      @Param("pageModel")PageModel pageModel);


    /**新增*/

    @Insert({
            "insert into technology_requirement (technology_requirement_id, technology_id, ",
            "requirement, add_time, ",
            "revise_time)",
            "values (#{technologyRequirementId,jdbcType=VARCHAR}, #{technologyId,jdbcType=VARCHAR}, ",
            "#{requirement,jdbcType=VARCHAR}, #{addTime,jdbcType=TIMESTAMP}, ",
            "#{reviseTime,jdbcType=TIMESTAMP})"
    })
    int insertTechnologyRequirement(TechnologyRequirement record);


    /**修改*/
    @Update({
            "update technology_requirement",
            "set technology_id = #{technologyId,jdbcType=VARCHAR},",
            "requirement = #{requirement,jdbcType=VARCHAR},",
            "add_time = #{addTime,jdbcType=TIMESTAMP},",
            "revise_time = #{reviseTime,jdbcType=TIMESTAMP}",
            "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TechnologyRequirement record);

    @Update({
            "update technology_requirement",
            "set requirement = #{requirement,jdbcType=VARCHAR}",
            "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    int updateRequirement(@Param("technologyRequirementId") String technologyRequirementId,
                          @Param("requirement")String requirement);


    /**删除*/
    @Delete({
            "delete from technology_requirement",
            "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String technologyRequirementId);

}