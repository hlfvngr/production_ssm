package com.cskaoyan.erp.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class Technology {


    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "工艺编号长度限制在40个字符以内")
    private String technologyId;

    @NotNull(message = "填写信息不能为空")
    @Size(max=100,message = "工艺名称长度限制在100个字符以内")
    private String technologyName;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 99999999,message = "外协价格不能超过99999999")
    private BigDecimal price;

    @NotNull(message = "填写信息不能为空")
    @Size(max = 50,message = "瓶颈工序工期长度限制在50个字符以内")
    private String vitalProcessPeriod;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "标准加工能力不能超过99999999")
    private Integer standardCapacity;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "加班标准加工能力不能超过99999999")
    private Integer overtimeStandardCapacity;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "加班超额加工能力不能超过99999999")
    private Integer overtimeOverfulfilCapacity;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "二倍工序能力不能超过99999999")
    private Integer doubleCapacity;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "超负荷工序能力不能超过99999999")
    private Integer overfulfilCapacity;

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName == null ? null : technologyName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVitalProcessPeriod() {
        return vitalProcessPeriod;
    }

    public void setVitalProcessPeriod(String vitalProcessPeriod) {
        this.vitalProcessPeriod = vitalProcessPeriod == null ? null : vitalProcessPeriod.trim();
    }

    public Integer getStandardCapacity() {
        return standardCapacity;
    }

    public void setStandardCapacity(Integer standardCapacity) {
        this.standardCapacity = standardCapacity;
    }

    public Integer getOvertimeStandardCapacity() {
        return overtimeStandardCapacity;
    }

    public void setOvertimeStandardCapacity(Integer overtimeStandardCapacity) {
        this.overtimeStandardCapacity = overtimeStandardCapacity;
    }

    public Integer getOvertimeOverfulfilCapacity() {
        return overtimeOverfulfilCapacity;
    }

    public void setOvertimeOverfulfilCapacity(Integer overtimeOverfulfilCapacity) {
        this.overtimeOverfulfilCapacity = overtimeOverfulfilCapacity;
    }

    public Integer getDoubleCapacity() {
        return doubleCapacity;
    }

    public void setDoubleCapacity(Integer doubleCapacity) {
        this.doubleCapacity = doubleCapacity;
    }

    public Integer getOverfulfilCapacity() {
        return overfulfilCapacity;
    }

    public void setOverfulfilCapacity(Integer overfulfilCapacity) {
        this.overfulfilCapacity = overfulfilCapacity;
    }
}