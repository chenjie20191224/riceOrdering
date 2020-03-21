package com.springbook.rice.controller;

import com.springbook.rice.common.domain.*;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import com.springbook.rice.mapper.OrderMapper;
import com.springbook.rice.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WelcomeController {
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Autowired
    OrderingService orderingService;
    @Autowired
    FoodMapper foodMapper;
    @RequestMapping("/getBusinessStatus")
    @ResponseBody
    public Boolean getBusinessStatus(){
        return businessMapper.selectByPrimaryKey(1).getBusinessStatus();
    }
    @RequestMapping("/setBusinessStatus")
    @ResponseBody
    public void setBusinessStatus(Boolean businessStatus){
        System.out.println(businessStatus);
        Business business=new Business();
        business.setBusinessId(1);
        business.setBusinessStatus(businessStatus);
         businessMapper.updateByPrimaryKeySelective(business);
    }
//    获取待配送订单的数量
    @RequestMapping("/getOrder_de")
    @ResponseBody
    public Integer getOrder_de(){
        OrderFoodExample orderExample=new OrderFoodExample();
        orderExample.createCriteria().andOrderStateEqualTo("待配送");
        return orderFoodMapper.selectByExample(orderExample).size();
    }
//
    @RequestMapping("/getOrder_sales")
    @ResponseBody
    public Double getOrder_sales(String start,String end){
        double sum=0;
        System.out.println("start:"+start+"  end:"+end);
        String[] split = start.split("-");
        start=split[0]+"年"+split[1]+"月"+split[2]+"日";
        String[] split2 = end.split("-");
        end=split2[0]+"年"+split2[1]+"月"+split2[2]+"日 23:59";
        System.out.println(start+end);
        OrderFoodExample orderFoodExample=new OrderFoodExample();
        orderFoodExample.createCriteria().andOrderTimeBetween(start,end).andOrderStateEqualTo("已配送");
        List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
        for (OrderFood orderFood : orderFoods) {
            double sum1 = orderFood.getActualPay().doubleValue();
            sum+= sum1;
        }
        return sum;
    }
    //    菜品数
    @RequestMapping("/getFood_num")
    @ResponseBody
    public Integer getFood_num(){
        FoodExample foodExample=new FoodExample();
        return foodMapper.selectByExample(foodExample).size();
    }

}
