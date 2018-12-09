package com.cskaoyan.erp.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class TechnologyPlan {

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "工艺计划编号长度限制在40个字符以内")
    private String technologyPlanId;

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "长度限制在40个字符以内")
    private String technologyId;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 999999999,message = "批次数量不能超过99999999")
    private Integer batchAmount;

    @NotNull(message = "填写信息不能为空")
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startPlan;

    @NotNull(message = "填写信息不能为空")
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endPlan;

    @NotNull(message = "填写信息不能为空")
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commitPlan;


    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date technologyPlanStart;

    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date technologyPlanEnd;

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Date getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(Date startPlan) {
        this.startPlan = startPlan;
    }

    public Date getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(Date endPlan) {
        this.endPlan = endPlan;
    }

    public Date getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(Date commitPlan) {
        this.commitPlan = commitPlan;
    }

    public Date getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(Date technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    public Date getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(Date technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }
}