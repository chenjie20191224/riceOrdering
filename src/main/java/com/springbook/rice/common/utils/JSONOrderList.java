package com.springbook.rice.common.utils;

import com.springbook.rice.common.domain.OrderFood;

import java.util.List;

public class JSONOrderList {
    private List<OrderFood> orderFoods;
    private Integer totalPage;

    public List<OrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(List<OrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
