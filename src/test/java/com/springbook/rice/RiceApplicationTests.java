package com.springbook.rice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbook.rice.common.domain.*;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.mapper.OrderFoodMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RiceApplicationTests {
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Test
    void contextLoads() {
        OrderFoodExample orderFoodExample=new OrderFoodExample();
        orderFoodExample.createCriteria().andOrderTimeBetween("2020年01月19日","2020年01月20日 23:59");
        List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
        for (OrderFood orderFood : orderFoods) {
            System.out.println(orderFood.getOrderTime());
        }



    }

}
