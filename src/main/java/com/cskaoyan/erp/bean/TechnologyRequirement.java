package com.cskaoyan.erp.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class TechnologyRequirement {

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "工艺要求编号长度限制在40个字符以内")
    private String technologyRequirementId;

    @NotNull(message = "填写信息不能为空")
    @Size(max=40,message = "长度限制在40个字符以内")
    private String technologyId;

    @NotNull(message = "填写信息不能为空")
    @Size(max=2000,message = "工艺要求长度限制在2000个字符以内")
    private String requirement;

    @NotNull(message = "填写信息不能为空")
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    @NotNull(message = "填写信息不能为空")
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reviseTime;


    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId == null ? null : technologyRequirementId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }
}