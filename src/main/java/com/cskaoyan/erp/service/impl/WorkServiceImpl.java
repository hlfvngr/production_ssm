package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Work;
import com.cskaoyan.erp.mapper.WorkMapper;
import com.cskaoyan.erp.service.WorkService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    public List<Work> selectAllWork(){
        return workMapper.selectAllWork();
    }

    public List<Work> selectWork(Work work, PageModel pageModel) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("workId",work.getWorkId());
        map.put("workProduct",work.getWorkProduct());
        map.put("workDevice",work.getWorkDevice());
        map.put("workProcess",work.getWorkProcess());
        int count = workMapper.count(map);
        if(count == 0){
            return null;
        }
        pageModel.setRecordCount(count);
        int offset = pageModel.getFirstLimitParam();
        int limit = pageModel.getRows();
        map.put("offset",offset);
        map.put("limit",limit);
        return workMapper.selectByPage(map);
    }

    public boolean insertWork(Work work) {
        return workMapper.insert(work) != 0;
    }

    public boolean updateWork(Work work) {
        return workMapper.updateByPrimaryKey(work) != 0;
    }

    public boolean deleteWork(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            int ret = workMapper.deleteByPrimaryKey(ids[i]);
            if(ret == 0) {
                return false;
            }
        }
        return true;
    }

    public Work findWorkById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }
}
