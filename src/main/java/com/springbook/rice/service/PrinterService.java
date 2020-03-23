package com.springbook.rice.service;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderFood;

public interface PrinterService {
    void printer(OrderFood orderFood, OrderDetail orderDetail);
}
