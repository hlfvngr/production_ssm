package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.MaterialReceive;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:  张娅迪
 * Date: 2018/12/08
 * Time: 上午 10:04
 * Detail requirement:
 * Method:
 */
public interface MaterialReceiveService {
    Map deleteByReceiveId(String[] materialReceiveIds);

    Map insert(MaterialReceive materialReceive);

    //改
    Map updateByReceiveId(MaterialReceive materialReceive);

    //查
    MaterialReceive findByReceiveId(String materialReceiveId);

    Map findMaterialReceivesByPage(MaterialReceive materialReceive, Integer page , Integer rows);

    Integer count(MaterialReceive materialReceive);
}
