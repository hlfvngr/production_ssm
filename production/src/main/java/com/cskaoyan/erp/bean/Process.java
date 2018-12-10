package com.cskaoyan.erp.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Process {

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "工序编号长度限制在40个字符以内")
    private String processId;

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "工艺计划长度限制在40个字符以内")
    private String technologyPlanId;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 99999999,message = "工序顺序不能超过99999999")
    private Integer sequence;

    @NotNull(message = "填写信息不能为空")
    @Max(value = 99999999,message = "单件定额工时不能超过99999999")
    private Integer quota;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }
}