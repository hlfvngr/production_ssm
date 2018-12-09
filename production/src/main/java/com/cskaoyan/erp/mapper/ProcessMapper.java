package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Process;
import com.cskaoyan.erp.util.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProcessMapper {


    int insertSelective(Process record);



    int updateByPrimaryKeySelective(Process record);




    /**工序管理*/


    /**显示*/
    @Select("select count(*) from process")
    public Integer processCount();

    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    public List<Process> selectProcessList(@Param("pageModel") PageModel pageModel);



    /**搜索*/

    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "where process_id LIKE CONCAT ('%',#{processId,jdbcType=VARCHAR},'%')"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    public List<Process> searchByProcessId(@Param("processId") String processId);

    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "where process_id LIKE CONCAT ('%',#{processId,jdbcType=VARCHAR},'%')",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    public List<Process> searchPageByProcessId(@Param("processId") String processId,
                                               @Param("pageModel") PageModel pageModel);

    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "where technology_plan_id LIKE CONCAT ('%',#{planId,jdbcType=VARCHAR},'%')"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    public List<Process> searchByPlanId(@Param("planId") String planId);

    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "where technology_plan_id LIKE CONCAT ('%',#{planId,jdbcType=VARCHAR},'%')",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    public List<Process> searchPageByPlanId(@Param("planId") String planId,
                                               @Param("pageModel") PageModel pageModel);


    /**新增*/
    @Insert({
            "insert into process (process_id, technology_plan_id, ",
            "sequence, quota)",
            "values (#{processId,jdbcType=VARCHAR}, #{technologyPlanId,jdbcType=VARCHAR}, ",
            "#{sequence,jdbcType=INTEGER}, #{quota,jdbcType=INTEGER})"
    })
    int insertProcess(Process record);

    /**更新*/
    @Update({
            "update process",
            "set technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR},",
            "sequence = #{sequence,jdbcType=INTEGER},",
            "quota = #{quota,jdbcType=INTEGER}",
            "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Process record);

    /**删除*/
    @Delete({
            "delete from process",
            "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String processId);


    /**开放接口*/
    @Select({
            "select",
            "process_id, technology_plan_id, sequence, quota",
            "from process",
            "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    Process selectByPrimaryKey(String processId);

}