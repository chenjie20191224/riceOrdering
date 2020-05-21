package com.springbook.rice.controller;

import com.springbook.rice.common.domain.Business;
import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.domain.Food;
import com.springbook.rice.common.domain.FoodExample;
import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.CategoryFoodMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.service.CategoryFoodService;
import com.springbook.rice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class foodListController {
    @Autowired
    FoodService foodService;
    @Autowired
    CategoryFoodService categoryFoodService;
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    FoodMapper foodMapper;


//跳转菜品列表并显示
    @RequestMapping("/food-list")
    public String foodList(Model model,String category,String foodName){
        //    菜品类别下拉框选择
        List<Food> foods=foodService.selectAll();
        if (category!=null){
             foods = foodService.selectByCategory(category);

        }
        if (category==null||category.equals("所有类别")){
            foodService.selectByCategory("初始化菜品类别下拉框的选择状态");
//             foods = foodService.selectAll();
        }
        if (foodName!=null&&!foodName.equals("")){
            FoodExample foodExample=new FoodExample();
            foodExample.createCriteria().andFoodNameEqualTo(foodName);
            foods=foodMapper.selectByExample(foodExample);
        }
        model.addAttribute("Foods",foods);
        List<CategoryFood> categoryFoods = categoryFoodService.selectAll();
        model.addAttribute("categoryFoods",categoryFoods);
        return "food-list";
    }

//菜品修改页面
    @RequestMapping("/food-edit")
    public String foodEdit(String foodName,Model model){
        //  更新菜品封面前先清空之前的保存的封面
        foodService.initFoodicon();
        Food food = foodService.selectByfoodName(foodName);
        model.addAttribute("food",food);
        List<CategoryFood> categoryFoods = categoryFoodService.selectAll();
        model.addAttribute("categoryFoods",categoryFoods);
        return "food-edit";
    }
//菜品添加页面
    @RequestMapping("/food-add")
    public String foodAdd(Model model){
        model.addAttribute("categoryFoods",categoryFoodService.selectAll());
        Business business = businessMapper.selectByPrimaryKey(1);
        model.addAttribute("packFEE",business==null?0.5:business.getPackFee());
        return "food-add";
    }
//菜品添加操作
    @RequestMapping("/foodAdd")
    @ResponseBody
    public void foodADD(Food food){
        foodService.foodAdd(food);
    }

//    菜品更新按钮点击  foodUpdate
    @RequestMapping("/foodUpdate")
    @ResponseBody
    public void foodUpdate(Food food){
        System.out.println("开始更新菜品：ID="+food.getId()+food.getFoodName());
        foodService.foodUpdate(food);
     }


//    菜品icon上传页面 foodIcon-add
    @RequestMapping("/foodIcon-add")
    public String businessEdit(String src,Model model) {

    model.addAttribute("src",src);
    return "foodIcon-add";
}

//    上传菜品图片
    @PostMapping("/uploadFood")
    @ResponseBody
    public JSONPhotos filesUpload(@RequestParam("file") MultipartFile file) {

        return foodService.uploadPhotos(file);
    }

//    确认选择图片
   @PostMapping("/submitIcon")
   @ResponseBody
   public Boolean submitIcon() {
    return foodService.iconConfirm();
  }


// 菜品添加时验证food是否已存在和菜品封面是否添加   foodVerify
    @PostMapping("/foodVerify")
    @ResponseBody
    public JSONResult foodVerify(String foodName) {

        return foodService.foodVerify(foodName);
}
//菜品更新时验证更新的菜品名是否存在
    @PostMapping("/foodNameVerify")
    @ResponseBody
    public JSONResult foodNameVerify(String foodName,String category) {
      String[] split = foodName.split(",");

      String s = split.length!=0?split[0]:null;
      System.out.println("开始验证菜品名："+s);
    return foodService.foodNameVerify(s,category);
    }
//菜品删除
    @PostMapping("/foodDelet")
    @ResponseBody
    public void foodDelet(String[] foodNames){
        System.out.println(foodNames);
        foodService.foodDelet(foodNames);
    }


}
