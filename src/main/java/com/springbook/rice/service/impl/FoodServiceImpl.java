package com.springbook.rice.service.impl;

import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.CategoryFoodExample;
import com.springbook.rice.common.domain.Food;
import com.springbook.rice.common.domain.FoodExample;
import com.springbook.rice.common.utils.FileUtils;
import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.CategoryFoodMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.service.CategoryFoodService;
import com.springbook.rice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("foodService")
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    CategoryFoodMapper categoryFoodMapper;
    @Autowired
    CategoryFoodService categoryFoodService;
    @Autowired
    BusinessMapper businessMapper;
    String foodIconUrl=null;
    String foodName_add=null;
    String iconConfirm=null;


    public JSONPhotos uploadPhotos(MultipartFile file){
        System.out.println("上传菜品图片到本地");
        JSONPhotos jsonPhotos = FileUtils.uploadPhotos(file);
        this.foodIconUrl=jsonPhotos.getUrl();
        return jsonPhotos;
    }
    public Boolean iconConfirm(){
        System.out.println("确认选择菜品封面");
        this.iconConfirm=foodIconUrl;
        return this.iconConfirm == null ? false : true;
    }

    public Food foodAdd(Food food){
        System.out.println("添加菜品"+this.foodName_add);
        food.setFoodName(this.foodName_add);
        food.setIcon(this.foodIconUrl);

        foodMapper.insert(food);
        this.iconConfirm=null;
        return food;
    }

    public List<Food> selectAll(){
        FoodExample foodExample=new FoodExample();
        List<Food> foods = foodMapper.selectByExample(foodExample);
        return foods;
    }

    public int foodUpdate(Food food){
//        没有输入更新的数据
        System.out.println("正在更新菜品");
        if (food.getFoodName()==null&&food.getPrice()==null&&food.getCategory().equals("")&&food.getDescrib().equals("")&&this.foodIconUrl==null&&food.getPackFee()==null){
            System.out.println("没有输入更新的数据,不用更新");
            return 0;
        }
        System.out.println("更新菜品");

//        没有更新图片用原有的
        if (foodIconUrl!=null){
//            更新了图片
            food.setIcon(this.foodIconUrl);
            this.foodIconUrl=null;
        }
        if (food.getFoodName().equals("")){
            food.setFoodName(null);
        }
        if (food.getDescrib().equals("")){
            food.setDescrib(null);
        }
        return foodMapper.updateByPrimaryKeySelective(food);
    }




    public int foodDelet(String[] strings){
        int delet=0;
        for (int i=0;i<strings.length;i++){
            System.out.println("删除"+strings[i]);
            if (foodMapper.deleteByPrimaryKey(selectByfoodName(strings[i]).getId())==1){
                delet++;
            }
        }
        return delet;
    }

    public Food selectByfoodName(String foodName){
        FoodExample foodExample=new FoodExample();
        foodExample.createCriteria().andFoodNameEqualTo(foodName);
        List<Food> foods = foodMapper.selectByExample(foodExample);
        return foods.size()!=0?foods.get(0):null;
    }

    public JSONResult foodVerify(String foodName){
        System.out.println("验证菜品是否已存在和菜品封面是否添加");
        JSONResult jsonResult=new JSONResult();
        System.out.println(this.iconConfirm);
        if (selectByfoodName(foodName)!=null){
            jsonResult.setSuccess(false);
            jsonResult.setMsg("菜品已存在");
        }else if (this.iconConfirm==null){

            jsonResult.setSuccess(false);
            jsonResult.setMsg("给这道菜选一个封面吧！");
        }
        else {
            this.foodName_add=foodName;
            jsonResult.setSuccess(true);
        }

        return jsonResult;
    }

    public JSONResult foodNameVerify(String foodName,String category){
        System.out.println("验证更新的菜品类别和菜品名是否存在");
        JSONResult jsonResult=new JSONResult();
        System.out.println(category);
        if (category.split(",")[0].equals("菜品类别")){
           jsonResult.setSuccess(false);
           jsonResult.setMsg("请选择菜品类别！");
           return jsonResult;
       }




        //        菜品名没有更新，不用验证
        if (foodName==null){
            System.out.println("没有更新菜品名");
            jsonResult.setSuccess(true);
            return jsonResult;
        }
        System.out.println("验证更新的菜品名是否存在");
        if (selectByfoodName(foodName)!=null){
            jsonResult.setSuccess(false);
            jsonResult.setMsg("菜品已存在");
        }else {
            jsonResult.setSuccess(true);
        }
        return jsonResult;
    }

    public List<Food> selectByCategory(String category){
        System.out.println("菜品类别下拉框选择");
        System.out.println("1.设置category_food的选择状态");
        if (category.equals("所有类别")){
            return selectAll();
        }
        List<CategoryFood> categoryFoods =categoryFoodService.selectAll();
        for (int i=0;i<categoryFoods.size();i++){
            if (categoryFoods.get(i).getCategory().equals(category)){
                categoryFoods.get(i).setSelected(true);
                categoryFoodMapper.updateByPrimaryKeySelective(categoryFoods.get(i));
            }else {
                categoryFoods.get(i).setSelected(false);
                categoryFoodMapper.updateByPrimaryKeySelective(categoryFoods.get(i));
            }

        }
        System.out.println("2.查找"+category);
        FoodExample foodExample=new FoodExample();
        foodExample.createCriteria().andCategoryEqualTo(category);
       return foodMapper.selectByExample(foodExample);

    }


}
