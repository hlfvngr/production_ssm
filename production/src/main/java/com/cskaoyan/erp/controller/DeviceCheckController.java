package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.DeviceCheck;
import com.cskaoyan.erp.bean.DeviceMaintain;
import com.cskaoyan.erp.bean.vo.DeviceCheckVo;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.service.DeviceCheckService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService service;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String, Object> deviceList(PageModel pageModel) {
        List<DeviceCheckVo> devices = service.findPage(pageModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", devices.size());
        map.put("rows", devices);
        return map;
    }

    @RequestMapping("search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceCheckByDeviceCheckId(PageModel pageModel, String searchValue) {
        DeviceCheckVo deviceCheck = new DeviceCheckVo();
        deviceCheck.setDeviceCheckId(searchValue);
        List<DeviceCheckVo> deviceChecks = service.findPageByCondition(pageModel, deviceCheck);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceChecks == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceChecks.size());
            map.put("rows", deviceChecks);
        }
        return map;
    }

    @RequestMapping("search_deviceCheck_by_deviceName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceCheckByDeviceName(PageModel pageModel, String searchValue) {
        DeviceCheckVo deviceCheck = new DeviceCheckVo();
        deviceCheck.setDeviceName(searchValue);
        List<DeviceCheckVo> deviceChecks = service.findPageByCondition(pageModel, deviceCheck);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceChecks == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceChecks.size());
            map.put("rows", deviceChecks);
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
        return "/deviceCheck_add";
    }

    @RequestMapping("edit")
    public String toEditPage() {
        return "/deviceCheck_edit";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDeviceType(DeviceCheck deviceCheck) {
        service.insertDeviceCheck(deviceCheck);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateDeviceType(DeviceCheck deviceCheck) {
        service.updateDeviceCheck(deviceCheck);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatchDeviceCheck(String[] ids) {
        service.deleteBatchDeviceCheck(ids);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map<String, Object> updateNote(DeviceCheck deviceCheck) {
        service.updateNote(deviceCheck);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }
}
