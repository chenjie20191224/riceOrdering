package com.springbook.rice.service;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderFood;

import java.io.IOException;
import java.util.List;

public interface PrinterService {
    Boolean printer(String data,String deviceid,String devicesecret) throws IOException;
    String templateData(String businessName,OrderFood orderFood, List<OrderDetail> orderDetail);
}
