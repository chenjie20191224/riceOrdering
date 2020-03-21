package com.springbook.rice.common.domain;

import java.math.BigDecimal;

public class Business {
    private Integer businessId;

    private String businessName;

    private String address;

    private String activity;

    private String deliveryTime;

    private Integer deliveryScope;

    private String chart1;

    private String chart2;

    private String chart3;

    private String businessLicense;

    private Integer startDelivery;

    private Integer deliveryFee;

    private String deliveryService;

    private String telephone;

    private BigDecimal packFee;

    private Integer serviceTime;

    private Boolean businessStatus;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public Integer getDeliveryScope() {
        return deliveryScope;
    }

    public void setDeliveryScope(Integer deliveryScope) {
        this.deliveryScope = deliveryScope;
    }

    public String getChart1() {
        return chart1;
    }

    public void setChart1(String chart1) {
        this.chart1 = chart1 == null ? null : chart1.trim();
    }

    public String getChart2() {
        return chart2;
    }

    public void setChart2(String chart2) {
        this.chart2 = chart2 == null ? null : chart2.trim();
    }

    public String getChart3() {
        return chart3;
    }

    public void setChart3(String chart3) {
        this.chart3 = chart3 == null ? null : chart3.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public Integer getStartDelivery() {
        return startDelivery;
    }

    public void setStartDelivery(Integer startDelivery) {
        this.startDelivery = startDelivery;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService == null ? null : deliveryService.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getPackFee() {
        return packFee;
    }

    public void setPackFee(BigDecimal packFee) {
        this.packFee = packFee;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Boolean getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(Boolean businessStatus) {
        this.businessStatus = businessStatus;
    }
}