package com.springbook.rice.service;

import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.Food;
import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {
    JSONPhotos uploadPhotos(MultipartFile file);
    Food foodAdd(Food food);
    List<Food> selectAll();
    int foodUpdate(Food food);
    JSONResult foodVerify(String foodName);
    int foodDelet(String[] strings);
    Food selectByfoodName(String foodName);
    JSONResult foodNameVerify(String foodName,String category);
    Boolean iconConfirm();
    List<Food> selectByCategory(String category);

}
