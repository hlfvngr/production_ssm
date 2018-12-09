package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.service.DeviceTypeService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/deviceType")
@Controller
public class DeviceTypeController {

    @Autowired
    DeviceTypeService service;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String,Object> deviceList(PageModel pageModel) {
        List<DeviceType> devices = service.findPage(pageModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", devices.size());
        map.put("rows", devices);
        return map;
    }

    @RequestMapping(value = "/get/{deviceTypeId}",method = RequestMethod.GET)
    @ResponseBody
    public DeviceType getDeviceType(@PathVariable(value = "deviceTypeId") String deviceTypeId) {
        DeviceType deviceType=service.getDeviceTypeById(deviceTypeId);
        return deviceType;
    }

    // 参数校验的地方
    /*@RequestMapping("edit_judge")
    public Map<String,Object> edit_judgeParam() {
        Map<String, Object> map = new HashMap<>();

        return map;
    }*/

    @RequestMapping(value = "update_all",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateAllDeviceType(DeviceType deviceType) {
        Map<String, Object> map = new HashMap<>();
        int flag=service.updateDeviceType(deviceType);
        if (flag == 1) {
            map.put("msg", "ok");
            map.put("status", 200);
        }
        return map;
    }

    @RequestMapping("search_deviceType_by_deviceTypeId")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceTypeId(PageModel pageModel,String searchValue) {
        DeviceType deviceType = new DeviceType();
        deviceType.setDeviceTypeId(searchValue);
        List<DeviceType> deviceTypes = service.findPageByCondition(pageModel,deviceType);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceTypes == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceTypes.size());
            map.put("rows", deviceTypes);
        }
        return map;
    }


    @RequestMapping("search_deviceType_by_deviceTypeName")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceTypeName(PageModel pageModel,String searchValue) {
        DeviceType deviceType = new DeviceType();
        deviceType.setDeviceTypeName(searchValue);
        List<DeviceType> deviceTypes = service.findPageByCondition(pageModel,deviceType);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceTypes == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceTypes.size());
            map.put("rows", deviceTypes);
        }
        return map;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<DeviceType> getData() {
        List<DeviceType> deviceTypes=service.getData();
        return deviceTypes;
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
        return "/deviceType_add";
    }

    @RequestMapping("edit")
    public String toEditPage() {
        return "/deviceType_edit";
    }


    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDeviceType(DeviceType deviceType) {
        service.insertDeviceType(deviceType);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateDeviceType(DeviceType deviceType) {
        service.updateDeviceType(deviceType);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatchDeviceType(String[] ids) {
        service.deleteBatchDeviceType(ids);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

}
