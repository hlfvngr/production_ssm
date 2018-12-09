package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.MaterialConsume;
import com.cskaoyan.erp.utils.PageModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:  张娅迪
 * Date: 2018/12/06
 * Time: 下午 5:13
 * Detail requirement:
 * Method:
 */
public interface MaterialConsumeService {
    Map deleteByConsumeId(String[] consumeIds);

    Map insert(MaterialConsume materialConsume);

    //改
    Map updateByConsumeId(MaterialConsume materialConsume);

    //查
    MaterialConsume findByConsumeId(String consumeId);

    Map findMaterialConsumesByPage(MaterialConsume materialConsume, Integer page , Integer rows);

    Integer count(MaterialConsume materialConsume);
}
