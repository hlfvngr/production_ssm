package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.DeviceFault;
import com.cskaoyan.erp.bean.DeviceMaintain;
import com.cskaoyan.erp.bean.vo.DeviceMaintainVo;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.service.DeviceMaintainService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService service;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String,Object> deviceList(PageModel pageModel) {
        List<DeviceMaintainVo> devices = service.findPage(pageModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", devices.size());
        map.put("rows", devices);
        return map;
    }

    @RequestMapping("search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public HashMap<String,Object> searchDeviceMaintainByDeviceFaultId(PageModel pageModel,String searchValue) {
        DeviceMaintainVo deviceMaintain = new DeviceMaintainVo();
        deviceMaintain.setDeviceFaultId(searchValue);
        List<DeviceMaintainVo> deviceMaintains = service.findPageByCondition(pageModel,deviceMaintain);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceMaintains == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceMaintains.size());
            map.put("rows", deviceMaintains);
        }
        return map;
    }

    @RequestMapping("search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public HashMap<String,Object> searchDeviceMaintainByDeviceMaintainId(PageModel pageModel,String searchValue) {
        DeviceMaintainVo deviceMaintain = new DeviceMaintainVo();
        deviceMaintain.setDeviceMaintainId(searchValue);
        List<DeviceMaintainVo> deviceMaintains = service.findPageByCondition(pageModel,deviceMaintain);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceMaintains == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceMaintains.size());
            map.put("rows", deviceMaintains);
        }
        return map;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Map addJudge() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public Map editJudge() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Map deleteJudge() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("add")
    public String toAddPage() {
        return "/deviceMaintain_add";
    }

    @RequestMapping("edit")
    public String toEditPage() {
        return "/deviceMaintain_edit";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        service.insertDeviceMaintain(deviceMaintain);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        service.updateDeviceMaintain(deviceMaintain);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatchDeviceMaintain(String[] ids) {
        service.deleteBatchDeviceMaintain(ids);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map<String, Object> updateNote(DeviceMaintain deviceMaintain) {
        service.updateNote(deviceMaintain);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }
}
