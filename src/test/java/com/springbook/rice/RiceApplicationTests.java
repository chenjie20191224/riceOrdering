package com.springbook.rice;

import com.springbook.rice.common.domain.Business;
import com.springbook.rice.common.domain.Food;
import com.springbook.rice.common.domain.FoodExample;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.FoodMapper;
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
    @Test
    void contextLoads() {

        FoodExample foodExample=new FoodExample();
        List<Food> foods = foodMapper.selectByExample(foodExample);
      for (int i=0;i<foods.size();i++){
          System.out.println(foods.get(i).getFoodName());
      }

    }

}
