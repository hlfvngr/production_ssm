package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.bean.VO.TechnologyPlanVO;
import com.cskaoyan.erp.util.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TechnologyPlanMapper {




    int insertSelective(TechnologyPlan record);



    int updateByPrimaryKeySelective(TechnologyPlan record);



    /**工艺计划*/

    /**显示*/
    @Select("select count(*) from technology_plan")
    public Integer technologyPlanCount();


    @Select({"select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    public List<TechnologyPlanVO> selectTechnologyPlanList(@Param("pageModel") PageModel pageModel);


    /**搜索*/

    @Select({"select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "where technology_plan_id LIKE CONCAT ('%',#{planId,jdbcType=VARCHAR},'%')"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    public List<TechnologyPlanVO> searchByPlanId(@Param("planId") String planId);


    @Select({"select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "where technology_plan_id LIKE CONCAT ('%',#{planId,jdbcType=VARCHAR},'%')",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    public List<TechnologyPlanVO> searchPageByPlanId(@Param("planId") String planId,
                                                 @Param("pageModel") PageModel pageModel);


    @Select({"select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%')"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    public List<TechnologyPlanVO> searchByTechnologyName(@Param("technologyName") String technologyName);


    @Select({"select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%')",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    public List<TechnologyPlanVO> searchPageByTechnologyName(@Param("technologyName") String technologyName,
                                                 @Param("pageModel") PageModel pageModel);




    /**回显*/
    @Select({
            "select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    List<TechnologyPlanVO> findAllTechnologyPlan();

    /**新增*/
    @Insert({
            "insert into technology_plan (technology_plan_id, technology_id, ",
            "batch_amount, start_plan, ",
            "end_plan, commit_plan, ",
            "technology_plan_start, technology_plan_end)",
            "values (#{technologyPlanId,jdbcType=VARCHAR}, #{technologyId,jdbcType=VARCHAR}, ",
            "#{batchAmount,jdbcType=INTEGER}, #{startPlan,jdbcType=TIMESTAMP}, ",
            "#{endPlan,jdbcType=TIMESTAMP}, #{commitPlan,jdbcType=TIMESTAMP}, ",
            "#{technologyPlanStart,jdbcType=TIMESTAMP}, #{technologyPlanEnd,jdbcType=TIMESTAMP})"
    })
    int insertTechnologyPlan(TechnologyPlan record);


    /**修改*/
    @Update({
            "update technology_plan",
            "set technology_id = #{technologyId,jdbcType=VARCHAR},",
            "batch_amount = #{batchAmount,jdbcType=INTEGER},",
            "start_plan = #{startPlan,jdbcType=TIMESTAMP},",
            "end_plan = #{endPlan,jdbcType=TIMESTAMP},",
            "commit_plan = #{commitPlan,jdbcType=TIMESTAMP},",
            "technology_plan_start = #{technologyPlanStart,jdbcType=TIMESTAMP},",
            "technology_plan_end = #{technologyPlanEnd,jdbcType=TIMESTAMP}",
            "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TechnologyPlan record);


    /**删除*/
    @Delete({
            "delete from technology_plan",
            "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String technologyPlanId);

    /**开放接口*/
    @Select({
            "select",
            "technology_plan_id, plan.technology_id, batch_amount, start_plan, end_plan, commit_plan ",
            "technology_plan_start, technology_plan_end,technology_name",
            "from technology_plan plan left join technology",
            "on plan.technology_id=technology.technology_id",
            "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.ResultMap")
    TechnologyPlanVO selectByPrimaryKey(@Param("technologyPlanId") String technologyPlanId);

}