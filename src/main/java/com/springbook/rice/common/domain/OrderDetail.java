package com.springbook.rice.common.domain;

import java.math.BigDecimal;

public class OrderDetail {
    private String orderId;

    private String foodName;

    private BigDecimal price;

    private Integer num;

    private String foodIcon;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFoodIcon() {
        return foodIcon;
    }

    public void setFoodIcon(String foodIcon) {
        this.foodIcon = foodIcon == null ? null : foodIcon.trim();
    }
}