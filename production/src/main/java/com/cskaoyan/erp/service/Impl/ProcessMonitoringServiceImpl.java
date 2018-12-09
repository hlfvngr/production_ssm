package com.cskaoyan.erp.service.Impl;

import com.cskaoyan.erp.bean.Process;
import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.bean.TechnologyRequirement;
import com.cskaoyan.erp.bean.VO.TechnologyPlanVO;
import com.cskaoyan.erp.bean.VO.TechnologyRequirementVO;
import com.cskaoyan.erp.mapper.ProcessMapper;

import com.cskaoyan.erp.mapper.TechnologyPlanMapper;
import com.cskaoyan.erp.mapper.TechnologyRequirementMapper;
import com.cskaoyan.erp.mapper.TechnologyMapper;
import com.cskaoyan.erp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cskaoyan.erp.service.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/6 10:32
 * @需求:
 * @思路说明:
 */
@Service
public class ProcessMonitoringServiceImpl implements ProcessMonitoringService {


    @Autowired
    private TechnologyMapper technologyMapper;

    @Autowired
    private TechnologyRequirementMapper requirementMapper;

    @Autowired
    private TechnologyPlanMapper technologyPlanMapper;

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private PageModel pageModel;




    /**显示*/

    @Transactional
    public Map<String,Object> findTechnologyList(PageModel pageModel) {

        Map<String,Object> map=new HashMap<String, Object>();

        Integer recordCount=technologyMapper.technologyCount();

        if (pageModel!=null) {

            pageModel.setRecordCount(recordCount);//必须

            List<Technology> technologyList = technologyMapper.selectTechnologyList(pageModel);

            map.put("total",recordCount);
            map.put("rows",technologyList);

            return map;

        }
        return null;
    }

    @Transactional
    public Map<String, Object> findTechnologyRequirementList(PageModel pageModel) {

        Map<String,Object> map=new HashMap<String, Object>();

        Integer recordCount=requirementMapper.requirementCount();

        if (pageModel!=null){

            pageModel.setRecordCount(recordCount);

            List<TechnologyRequirementVO> requirementList= requirementMapper.selectRequirementList(pageModel);

            map.put("total",recordCount);
            map.put("rows",requirementList);

            return map;
        }

        return null;
    }

    @Transactional
    public Map<String, Object> findTechnologyPlanList(PageModel pageModel) {

        Map<String,Object> map=new HashMap<String, Object>();

        Integer recordCount=technologyPlanMapper.technologyPlanCount();

        if (pageModel!=null){

            pageModel.setRecordCount(recordCount);

            List<TechnologyPlanVO> technologyPlanList=technologyPlanMapper.selectTechnologyPlanList(pageModel);

            map.put("total",recordCount);
            map.put("rows",technologyPlanList);

            return map;
        }

        return null;
    }

    @Transactional
    public Map<String, Object> findProcessList(PageModel pageModel) {

        Map<String,Object> map=new HashMap<String, Object>();

        Integer recordCount=processMapper.processCount();

        if (pageModel!=null){

            pageModel.setRecordCount(recordCount);

            List<Process> processList=processMapper.selectProcessList(pageModel);

            map.put("total",recordCount);
            map.put("rows",processList);

            return map;

        }

        return null;
    }

    public boolean insertTechnology(Technology technology) {

        int insert=technologyMapper.insertTechnology(technology);

        if (insert==1){
            return true;
        }
        return false;
    }


    public boolean updateByPrimaryKey(Technology technology) {
        int update=technologyMapper.updateByPrimaryKey(technology);
        if (update==1){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteTechnology(String[] ids) {

        boolean flag=true;
        for (String id:ids) {
            int delete = technologyMapper.deleteByPrimaryKey(id);
            if (delete==0){
                flag=false;
            }
        }
        return flag;
    }


    /**搜索*/

    @Transactional
    public Map<String, Object> searchTechnologyByTechnologyId(String searchValue, PageModel pageModel) {

        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<Technology> technologies=technologyMapper.searchByTechnologyId(searchValue);

        Integer size=technologies.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<Technology> technologyList=technologyMapper.searchPageByTechnologyId(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",technologyList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchTechnologyByTechnologyName(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<Technology> technologies=technologyMapper.searchByTechnologyName(searchValue);

        Integer size=technologies.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<Technology> technologyList=technologyMapper.searchPageByTechnologyName(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",technologyList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchRequirementByRequirementId(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<TechnologyRequirementVO> requirementVOS=requirementMapper.searchByRequirementId(searchValue);

        Integer size=requirementVOS.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<TechnologyRequirementVO> requirementVOList=requirementMapper.searchPageByRequirementId(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",requirementVOList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchRequirementByTechnologyName(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<TechnologyRequirementVO> requirementVOS=requirementMapper.searchByTechnologyName(searchValue);

        Integer size=requirementVOS.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<TechnologyRequirementVO> requirementVOList=requirementMapper.searchPageByTechnologyName(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",requirementVOList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchPlanByPlanId(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<TechnologyPlanVO> technologyPlanVOS=technologyPlanMapper.searchByPlanId(searchValue);

        Integer size=technologyPlanVOS.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<TechnologyPlanVO> technologyPlanVOList=technologyPlanMapper.searchPageByPlanId(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",technologyPlanVOList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchPlanByTechnologyName(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<TechnologyPlanVO> technologyPlanVOS=technologyPlanMapper.searchByTechnologyName(searchValue);

        Integer size=technologyPlanVOS.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<TechnologyPlanVO> technologyPlanVOList=technologyPlanMapper.searchPageByTechnologyName(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",technologyPlanVOList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchProcessByProcessId(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<Process> processes=processMapper.searchByProcessId(searchValue);

        Integer size=processes.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<Process> processList=processMapper.searchPageByProcessId(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",processList);
        }

        return map;
    }

    @Transactional
    public Map<String, Object> searchProcessByPlanId(String searchValue, PageModel pageModel) {
        if (searchValue==null||pageModel==null){
            return null;
        }

        Map<String,Object> map=new HashMap<String, Object>();

        List<Process> processes=processMapper.searchByPlanId(searchValue);

        Integer size=processes.size();

        pageModel.setRecordCount(size);
        map.put("total",size);

        List<Process> processList=processMapper.searchPageByPlanId(searchValue,pageModel);

        if (size==0){
            map.put("rows","");
        }else {
            map.put("rows",processList);
        }

        return map;
    }


    public List<Technology> findAllTechnology() {

        List<Technology> list=technologyMapper.findAllTechnology();
        return list;
    }


    public boolean insertTechnologyRequirement(TechnologyRequirement requirement) {
        int insert=requirementMapper.insertTechnologyRequirement(requirement);

        if (insert==1){
            return true;
        }
        return false;
    }



    public boolean updateTechnologyRequirement(TechnologyRequirement requirement) {

        int update=requirementMapper.updateByPrimaryKey(requirement);

        if (update==1){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteTechnologyRequirement(String[] ids) {

            boolean flag=true;
            for (String id:ids) {
                int delete = requirementMapper.deleteByPrimaryKey(id);
                if (delete==0){
                    flag=false;
                }

            }
            return flag;
    }




    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan) {
        int insert=technologyPlanMapper.insertTechnologyPlan(technologyPlan);

        if (insert==1){
            return true;
        }
        return false;
    }

    public boolean updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int update=technologyPlanMapper.updateByPrimaryKey(technologyPlan);

        if (update==1){
            return true;
        }
        return false;
    }

    public boolean deleteTechnologyPlan(String[] ids) {
        boolean flag=true;
        for (String id:ids) {
            int delete = technologyPlanMapper.deleteByPrimaryKey(id);
            if (delete==0){
                flag=false;
            }
        }
        return flag;
    }

    public List<TechnologyPlanVO> findAllTechnologyPlan() {

        List<TechnologyPlanVO> list=technologyPlanMapper.findAllTechnologyPlan();
        return list;
    }

    public boolean insertProcess(Process process) {
        int insert=processMapper.insertProcess(process);

        if (insert==1){
            return true;
        }
        return false;
    }

    public boolean updateProcess(Process process) {
        int update=processMapper.updateByPrimaryKey(process);

        if (update==1){
            return true;
        }
        return false;
    }

    public boolean deleteProcess(String[] ids) {
        boolean flag=true;
        for (String id:ids) {
            int delete = processMapper.deleteByPrimaryKey(id);
            if (delete==0){
                flag=false;
            }
        }
        return flag;
    }

    public boolean updateRequirement(String technologyRequirementId, String requirement) {
        int update=requirementMapper.updateRequirement(technologyRequirementId,requirement);

        if (update==1){
            return true;
        }
        return false;
    }

    public Technology getTechnologyById(String technologyId) {
        Technology technology=technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    public TechnologyPlanVO getTechnologyPlanById(String technologyPlanId) {
        TechnologyPlanVO technologyPlanVO=technologyPlanMapper.selectByPrimaryKey(technologyPlanId);

        return technologyPlanVO;
    }

    public Process getProcessById(String processId) {
        Process process=processMapper.selectByPrimaryKey(processId);

        return process;
    }


}
