package com.springbook.rice.controller;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderDetailExample;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.PrinterNew;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.OrderDetailMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.mapper.PrinterNewMapper;
import com.springbook.rice.service.PrinterService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class PrinterController {
    @Autowired
    PrinterNewMapper printerNewMapper;
    @Autowired
    PrinterService printerService;
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    String  businessName="";
    String deviceid="";
    String devicesecret="";

    @RequestMapping("/printerUpdate")
    @ResponseBody
    public JSONResult printerUpdate(PrinterNew printer){
        System.out.println(printer.getId()+printer.getDeviceidid()+printer.getDevicesecret());
        JSONResult jsonResult=new JSONResult();
        PrinterNew printer1 = printerNewMapper.selectByPrimaryKey(1);
        if (printer1!=null){
            printer1.setDevicesecret(printer.getDevicesecret());
            printer1.setDeviceidid(printer.getDeviceidid());
            printerNewMapper.updateByPrimaryKey(printer1);
        }else {
            printerNewMapper.insert(printer);
        }
        jsonResult.setSuccess(true);
        jsonResult.setMsg("打印机设置成功！");
       return jsonResult;
    }
    @RequestMapping("/printer-update")
    public String printer_update(Model model){
        PrinterNew printerNew = printerNewMapper.selectByPrimaryKey(1);
        model.addAttribute("printer",printerNew);
        return "printer";
    }

    @RequestMapping("/printerTest")
    @ResponseBody
    public JSONResult printerTest(PrinterNew printerNew) throws IOException {
       JSONResult jsonResult=new JSONResult();
       String data="测试:设备ID="+printerNew.getDeviceidid()+"设备密钥="+printerNew.getDevicesecret();
        System.out.println(data);
        Boolean printer = printerService.printer(data, printerNew.getDeviceidid(), printerNew.getDevicesecret());
        if (printer){
            jsonResult.setMsg("云打印请求成功，若打印机无反应，请检查‘设备ID’、‘设备密钥’是否正确和云打印机是否能正常使用！");
            jsonResult.setSuccess(true);
        }else {
            jsonResult.setMsg("云打印请求失败，请联系系统维护员进行检查！");
            jsonResult.setSuccess(false);
        }
//        jsonResult.setMsg("正在测试打印");
        return jsonResult;
    }

    @RequestMapping("/Printer")
    @ResponseBody
    public void Printer(String orderId) throws ClientProtocolException, IOException {
        PrinterNew printerNew = printerNewMapper.selectByPrimaryKey(1);
        businessName=businessMapper.selectByPrimaryKey(1).getBusinessName();
        deviceid=printerNew.getDeviceidid();
        devicesecret=printerNew.getDevicesecret();
        OrderFood orderFood = orderFoodMapper.selectByPrimaryKey(orderId);
        OrderDetailExample orderDetailExample=new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(orderDetailExample);
//
//      打印的内容
        String data = printerService.templateData(this.businessName, orderFood, orderDetails);
        System.out.println(data);
////      开始打印
        printerService.printer(data,this.deviceid,this.devicesecret);

    }

}


