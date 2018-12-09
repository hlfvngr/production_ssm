package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Device;
import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.service.DeviceListService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService service;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String,Object> deviceList(PageModel pageModel) {
        List<DeviceVo> devices = service.findPage(pageModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", devices.size());
        map.put("rows", devices);
        return map;
    }

    @RequestMapping(value = "/get/{deviceId}",method = RequestMethod.GET)
    @ResponseBody
    public Device getDeviceType(@PathVariable(value = "deviceId") String deviceId) {
        Device device=service.getDeviceById(deviceId);
        return device;
    }

    @RequestMapping("search_device_by_deviceId")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceId(PageModel pageModel,String searchValue) {
        DeviceVo device = new DeviceVo();
        device.setDeviceId(searchValue);
        List<DeviceVo> devices = service.findPageByCondition(pageModel,device);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (devices == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", devices.size());
            map.put("rows", devices);
        }
        return map;
    }

    @RequestMapping("search_device_by_deviceName")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceName(PageModel pageModel,String searchValue) {
        DeviceVo device = new DeviceVo();
        device.setDeviceName(searchValue);
        List<DeviceVo> devices = service.findPageByCondition(pageModel,device);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (devices == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", devices.size());
            map.put("rows", devices);
        }
        return map;
    }

    @RequestMapping("search_device_by_deviceTypeName")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceTypeName(PageModel pageModel,String searchValue) {
        DeviceVo device = new DeviceVo();
        device.setDeviceTypeName(searchValue);
        List<DeviceVo> devices = service.findPageByCondition(pageModel,device);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (devices == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", devices.size());
            map.put("rows", devices);
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
        return "/deviceList_add";
    }

    @RequestMapping("edit")
    public String toEditPage() {
        return "/deviceList_edit";
    }


    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDevice(Device device) {
        service.insertDevice(device);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateDevice(Device device) {
        service.updateDevice(device);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatchDevice(String[] ids) {
        service.deleteBatchDevice(ids);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Device> getData() {
        List<Device> devices = service.getData();
        return devices;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map<String, Object> updateAllDevice(Device device) {
        service.updateDevice(device);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map<String, Object> updateNote(Device device) {
        service.updateNote(device);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }


}
