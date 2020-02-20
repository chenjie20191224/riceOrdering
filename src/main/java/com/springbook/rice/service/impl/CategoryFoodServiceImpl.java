package com.springbook.rice.service.impl;

import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.CategoryFoodExample;
import com.springbook.rice.common.domain.FoodExample;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.CategoryFoodMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.service.CategoryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryFoodService")
public class CategoryFoodServiceImpl implements CategoryFoodService {
    @Autowired
    CategoryFoodMapper categoryFoodMapper;
    @Autowired
    FoodMapper foodMapper;
    public List<CategoryFood> selectAll(){
        CategoryFoodExample categoryFoodExample=new CategoryFoodExample();
        List<CategoryFood> categoryFoods = categoryFoodMapper.selectByExample(categoryFoodExample);
        return categoryFoods;
    }

//    category交换
    public void changeCategory(String category1,String category2){
        System.out.println(category1+"与"+category2+"交换");
        CategoryFood categoryFood=new CategoryFood();
        CategoryFoodExample categoryFoodExample=new CategoryFoodExample();
        categoryFood.setCategory("flag");
        categoryFoodExample.createCriteria().andCategoryEqualTo(category1);
        categoryFoodMapper.updateByExampleSelective(categoryFood,categoryFoodExample);
        categoryFood.setCategory(category1);
        CategoryFoodExample categoryFoodExample2=new CategoryFoodExample();
        categoryFoodExample2.createCriteria().andCategoryEqualTo(category2);
        categoryFoodMapper.updateByExampleSelective(categoryFood,categoryFoodExample2);
        categoryFood.setCategory(category2);
        CategoryFoodExample categoryFoodExample3=new CategoryFoodExample();
        categoryFoodExample3.createCriteria().andCategoryEqualTo("flag");
        categoryFoodMapper.updateByExampleSelective(categoryFood,categoryFoodExample3);

    }

    public JSONResult categoryDwon(String category){
        System.out.println(category+"下移");
        JSONResult jsonResult=new JSONResult();
        List<CategoryFood> categoryFoods = selectAll();
        for (int i=0;i<categoryFoods.size();i++){
            if(categoryFoods.get(categoryFoods.size()-1).getCategory().equals(category)){
                jsonResult.setSuccess(false);
                jsonResult.setMsg("已经到低了！");
                return jsonResult;
            }
            if (categoryFoods.get(i).getCategory().equals(category)){
                   changeCategory(category,categoryFoods.get(i+1).getCategory());
            }
        }
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    public JSONResult categoryUp(String category){
        System.out.println(category+"上移");
        JSONResult jsonResult=new JSONResult();
        List<CategoryFood> categoryFoods = selectAll();
        for (int i=0;i<categoryFoods.size();i++){
            if(categoryFoods.get(0).getCategory().equals(category)){
                jsonResult.setSuccess(false);
                jsonResult.setMsg("已经到顶了！");
                return jsonResult;
            }
            if (categoryFoods.get(i).getCategory().equals(category)){
                changeCategory(category,categoryFoods.get(i-1).getCategory());
            }
        }
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    public JSONResult categoryDelete(String category){
        System.out.println("删除food表类别是"+category);
        JSONResult jsonResult=new JSONResult();
        FoodExample foodExample=new FoodExample();
        foodExample.createCriteria().andCategoryEqualTo(category);
        foodMapper.deleteByExample(foodExample);
        System.out.println("删除category_food表类别是"+category);
        CategoryFoodExample categoryFoodExample=new CategoryFoodExample();
        categoryFoodExample.createCriteria().andCategoryEqualTo(category);
        categoryFoodMapper.deleteByExample(categoryFoodExample);
        jsonResult.setSuccess(true);
        return jsonResult;

    }

    public JSONResult categoryAdd(String category){
        System.out.println("增加类别"+category);
        JSONResult jsonResult=new JSONResult();
        CategoryFoodExample categoryFoodExample=new CategoryFoodExample();
        categoryFoodExample.createCriteria().andCategoryEqualTo(category);
        if (categoryFoodMapper.selectByExample(categoryFoodExample).size()==0){
            CategoryFood categoryFood=new CategoryFood();
            categoryFood.setCategory(category);
            categoryFoodMapper.insertSelective(categoryFood);
            jsonResult.setSuccess(true);
        }else {
            jsonResult.setSuccess(false);
            jsonResult.setMsg(category+"类别已存在！");
        }

        return jsonResult;
    }

}
