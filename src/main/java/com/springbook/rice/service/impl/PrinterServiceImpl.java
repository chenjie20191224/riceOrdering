package com.springbook.rice.service.impl;

import com.springbook.rice.common.domain.OrderDetail;
import com.springbook.rice.common.domain.OrderFood;
import com.springbook.rice.common.domain.Printer;
import com.springbook.rice.common.utils.printerUtil;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.service.PrinterService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("printerService")
public class PrinterServiceImpl implements PrinterService {
    @Autowired
    BusinessMapper businessMapper;
    public Boolean printer(String data,String deviceid,String devicesecret) throws ClientProtocolException, IOException  {
        System.out.println("小票打印");
        String url = "http://api.zhongwuyun.com";
        Printer printer = new Printer();
        int time =Math.round(new Date().getTime()/1000);//时间戳
        printer.setAppid(8000393);//appid
        printer.setAppsecret("cc853a7740a30ede3d4db1d1b147870f");//appsecret
        printer.setDeviceid(deviceid);//设备id
        printer.setDevicesecret(devicesecret);//设备秘钥
        printer.setTimestamp(time);//时间戳
        printer.setData(data);
        String sign = printerUtil.getSign(printer);
        System.out.println("time："+time);
        System.out.println("url："+printerUtil.percentEncode(data));
        System.out.println("sign："+sign);
        //请求数据
        String datas = "appid="+printer.getAppid()+"&sign="+sign+"&timestamp="+time+"&deviceid="+
                printer.getDeviceid()+"&devicesecret="+printer.getDevicesecret()+"&printdata="+printerUtil.percentEncode(data);
        System.out.println(datas);
        return printerUtil.sendPost(url, datas);
    }

    public String templateData(String businessName,OrderFood orderFood, List<OrderDetail> orderDetail){
        String data="";
//        商家名字
        data+="<MS>2</MS><S1><C>*"+businessName+"*</C></S1>";
//        在线支付
        data+="--------------------------------<S2><C>--在线支付--</C></S2>";
//        备注
        data+="<H2><S1>备注："+"[餐具数量:"+orderFood.getTablewareQuantity()+"]"+orderFood.getRemarks()+"</S1><RN></H2>";
//        下单时间
        data+="下单时间:"+orderFood.getOrderTime()+"<RN>";
//        订单编号
        data+="订单编号:"+orderFood.getOrderId()+"<RN>********************************";
//        菜品信息
        data+="<B1><C>-----------菜品信息-----------</C></B1>";
        data+="<H2>";
        for (OrderDetail detail : orderDetail) {
            data+="<TR><TD>"+detail.getFoodName()+"</TD><TD>×"+detail.getNum()+"</TD><TD>"+detail.getPrice()+"</TD></TR>";
        }
        data+="</H2><B1>--------------其他--------------</B1>";
//        配送费
        data+="餐盒费: ￥"+orderFood.getDeliveryFee()+"<RN>";
//        餐盒费
        data+="配送费: ￥"+orderFood.getPackFee()+"<RN>";
//        订单总价
        data+="******************************** <RN><B1> 总价:<S2>"+orderFood.getActualPay()+"</S2><RN></B1>";
//        配送地址
        data+="<B1><S2>"+orderFood.getAddress()+"</S2><RN></B1>";
//        用户信息
        data+="<B1><S2>"+orderFood.getUserName()+"("+orderFood.getSex()+")"+"</S2><RN></B1><B1><S2>"+orderFood.getTelephone()+"</S2><RN></B1>";
        return data;
    }
}
