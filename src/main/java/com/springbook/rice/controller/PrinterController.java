package com.springbook.rice.controller;

import com.springbook.rice.common.domain.PrinterNew;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.PrinterNewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrinterController {
    @Autowired
    PrinterNewMapper printerNewMapper;
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
}


