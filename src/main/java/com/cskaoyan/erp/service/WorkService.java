package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Work;
import com.cskaoyan.erp.utils.page.PageModel;

import java.util.List;

public interface WorkService {

    List<Work> selectAllWork();

    List<Work> selectWork(Work work, PageModel pageModel);

    boolean insertWork(Work work);

    boolean updateWork(Work work);

    boolean deleteWork(String[] ids);

    Work findWorkById(String workId);
}
