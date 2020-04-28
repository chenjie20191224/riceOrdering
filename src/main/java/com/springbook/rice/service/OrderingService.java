package com.springbook.rice.service;

import com.springbook.rice.common.domain.OrderFood;

import java.util.List;

public interface OrderingService {
    List<OrderFood> orderAll();
    List<OrderFood> selectOrder(String status);
    void setPage(Integer pageNum,Integer pageSize);
    Boolean completeOrder(String orderId);
    Boolean refund(String orderId);
    List<OrderFood> selectOrderByStatus(String status);
    List<OrderFood> sreach(String start,String end,String orderId,String status);
    Integer allDelete(String[] orderIdList);

}
