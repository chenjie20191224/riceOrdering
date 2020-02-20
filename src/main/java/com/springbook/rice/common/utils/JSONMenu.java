package com.springbook.rice.common.utils;

import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.Food;

import java.util.List;

public class JSONMenu {
    List<Food> foods;
    List<CategoryFood> categoryFoods;
    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<CategoryFood> getCategoryFoods() {
        return categoryFoods;
    }

    public void setCategoryFoods(List<CategoryFood> categoryFoods) {
        this.categoryFoods = categoryFoods;
    }




}
