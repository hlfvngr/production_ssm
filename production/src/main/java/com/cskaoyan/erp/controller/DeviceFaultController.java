package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.DeviceCheck;
import com.cskaoyan.erp.bean.DeviceFault;
import com.cskaoyan.erp.bean.DeviceType;
import com.cskaoyan.erp.bean.vo.DeviceFaultVo;
import com.cskaoyan.erp.bean.vo.DeviceVo;
import com.cskaoyan.erp.service.DeviceFaultService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService service;

    @RequestMapping("list")
    @ResponseBody
    public HashMap<String,Object> deviceList(PageModel pageModel) {
        List<DeviceFaultVo> devices = service.findPage(pageModel);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", devices.size());
        map.put("rows", devices);
        return map;
    }

    @RequestMapping("search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public HashMap<String,Object> searchDeviceFaultByDeviceId(PageModel pageModel,String searchValue) {
        DeviceFaultVo deviceFault = new DeviceFaultVo();
        deviceFault.setDeviceFaultId(searchValue);
        List<DeviceFaultVo> deviceFaults = service.findPageByCondition(pageModel,deviceFault);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceFaults == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceFaults.size());
            map.put("rows", deviceFaults);
        }
        return map;
    }

    @RequestMapping("search_deviceFault_by_deviceName")
    @ResponseBody
    public HashMap<String,Object> searchDeviceByDeviceFaultName(PageModel pageModel,String searchValue) {
        DeviceFaultVo deviceFault = new DeviceFaultVo();
        deviceFault.setDeviceName(searchValue);
        List<DeviceFaultVo> deviceFaults = service.findPageByCondition(pageModel,deviceFault);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (deviceFaults == null) {
            map.put("total", 0);
            map.put("rows", "");
        } else {
            map.put("total", deviceFaults.size());
            map.put("rows", deviceFaults);
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
        return "/deviceFault_add";
    }

    @RequestMapping("edit")
    public String toEditPage() {
        return "/deviceFault_edit";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDeviceFault(DeviceFault deviceFault) {
        service.insertDeviceFault(deviceFault);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateDeviceType(DeviceFault deviceFault) {
        service.updateDeviceFault(deviceFault);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatchDeviceFault(String[] ids) {
        service.deleteBatchDeviceFault(ids);
        Map<String,Object> map=new HashMap<>();
        map.put("mag", null);
        map.put("status", "200");
        return map;
    }

    @RequestMapping("/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getDeviceFault(@PathVariable String deviceFaultId) {
        DeviceFault deviceFault=service.getDeviceFault(deviceFaultId);
        return deviceFault;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map<String, Object> updateAllDevice(DeviceFault deviceFault) {
        service.updateDeviceFault(deviceFault);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public DeviceFault getData() {
        DeviceFault deviceFault=service.getData();
        return deviceFault;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map<String, Object> updateNote(DeviceFault deviceFault) {
        service.updateNote(deviceFault);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "ok");
        map.put("status", 200);
        return map;
    }
}
