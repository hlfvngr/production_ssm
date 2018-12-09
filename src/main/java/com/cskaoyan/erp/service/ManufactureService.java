package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Manufacture;
import com.cskaoyan.erp.utils.page.PageModel;

import java.util.List;

public interface ManufactureService {

    boolean insertManufacture(Manufacture manufacture);

    List<Manufacture> findManufacture(Manufacture manufacture, PageModel pageModel);

    boolean updateManufacture(Manufacture manufacture);

    boolean deleteManufacture(String[] ids);

    Manufacture findManufactureById(String manufactureId);
}
