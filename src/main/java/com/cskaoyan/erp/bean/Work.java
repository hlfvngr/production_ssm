package com.cskaoyan.erp.bean;

public class Work {
    private String workId;

    private String processNumber;

    private Product workProduct;

    private Process workProcess;

    private Device workDevice;

    private Integer rating;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    public Product getWorkProduct() {
        return workProduct;
    }

    public void setWorkProduct(Product workProduct) {
        this.workProduct = workProduct;
    }

    public Process getWorkProcess() {
        return workProcess;
    }

    public void setWorkProcess(Process workProcess) {
        this.workProcess = workProcess;
    }

    public Device getWorkDevice() {
        return workDevice;
    }

    public void setWorkDevice(Device workDevice) {
        this.workDevice = workDevice;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}