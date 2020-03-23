package com.springbook.rice.service.impl;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.service.PrinterService;
import org.springframework.stereotype.Service;

@Service("printerService")
public class PrinterServiceImpl implements PrinterService {
    public void printer(OrderFood orderFood, OrderDetail orderDetail){
        System.out.println("小票打印");

    }
}
