package com.cskaoyan.erp.bean;

public class Work {
    private String workId;

    private String processNumber;

    private String productId;

    private String processId;

    private String deviceId;
    private Product workProduct;

    private Process workProcess;

    private Device workDevice;

    private Integer rating;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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