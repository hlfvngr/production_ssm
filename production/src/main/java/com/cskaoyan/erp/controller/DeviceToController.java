package com.cskaoyan.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("device")
public class DeviceToController {
    @RequestMapping("deviceList")
    public String deviceList() {
        return "redirect:/deviceList";
    }

    @RequestMapping("deviceType")
    public String deviceType() {
        return "redirect:/deviceType";
    }

    @RequestMapping("deviceCheck")
    public String deviceCheck() {
        return "redirect:/deviceCheck";
    }

    @RequestMapping("deviceFault")
    public String deviceFault() {
        return "redirect:/deviceFault";
    }

    @RequestMapping("deviceMaintain")
    public String deviceMaintain() {
        return "redirect:/deviceMaintain";
    }
}
