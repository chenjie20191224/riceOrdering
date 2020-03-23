package com.springbook.rice.common.domain;

public class PrinterNew {
    private Integer id;

    private String deviceidid;

    private String devicesecret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceidid() {
        return deviceidid;
    }

    public void setDeviceidid(String deviceidid) {
        this.deviceidid = deviceidid == null ? null : deviceidid.trim();
    }

    public String getDevicesecret() {
        return devicesecret;
    }

    public void setDevicesecret(String devicesecret) {
        this.devicesecret = devicesecret == null ? null : devicesecret.trim();
    }
}