package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.bean.TechnologyRequirement;
import com.cskaoyan.erp.bean.VO.TechnologyPlanVO;
import com.cskaoyan.erp.bean.VO.TechnologyRequirementVO;
import com.cskaoyan.erp.bean.Process;
import com.cskaoyan.erp.util.PageModel;

import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/6 10:31
 * @需求:
 * @思路说明:
 */
public interface ProcessMonitoringService {

    public Map<String,Object> findTechnologyList(PageModel pageModel);

    public Map<String,Object> findTechnologyRequirementList(PageModel pageModel);

    public Map<String,Object> findTechnologyPlanList(PageModel pageModel);

    public Map<String,Object> findProcessList(PageModel pageModel);

    public boolean insertTechnology(Technology technology);

    public boolean updateByPrimaryKey(Technology technology);

    public boolean deleteTechnology(String[] ids);

    public Map<String,Object> searchTechnologyByTechnologyId(String searchValue,PageModel pageModel);

    public Map<String,Object> searchTechnologyByTechnologyName(String searchValue,PageModel pageModel);

    public Map<String,Object> searchRequirementByRequirementId(String searchValue,PageModel pageModel);

    public Map<String,Object> searchRequirementByTechnologyName(String searchValue,PageModel pageModel);

    public Map<String,Object> searchPlanByPlanId(String searchValue,PageModel pageModel);

    public Map<String,Object> searchPlanByTechnologyName(String searchValue,PageModel pageModel);

    public Map<String,Object> searchProcessByProcessId(String searchValue,PageModel pageModel);

    public Map<String,Object> searchProcessByPlanId(String searchValue,PageModel pageModel);

    public List<Technology> findAllTechnology();

    public boolean insertTechnologyRequirement(TechnologyRequirement requirement);

    public boolean updateTechnologyRequirement(TechnologyRequirement requirement);

    public boolean deleteTechnologyRequirement(String[] ids);

    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan);

    public boolean updateTechnologyPlan(TechnologyPlan technologyPlan);

    public boolean deleteTechnologyPlan(String[] ids);

    public List<TechnologyPlanVO> findAllTechnologyPlan();

    public boolean insertProcess(Process process);

    public boolean updateProcess(Process process);

    public boolean deleteProcess(String[] ids);

    public boolean updateRequirement(String technologyRequirementId,String requirement);

    public Technology getTechnologyById(String technologyId);

    public TechnologyPlanVO getTechnologyPlanById(String technologyPlanId);

    public Process getProcessById(String processId);
}
