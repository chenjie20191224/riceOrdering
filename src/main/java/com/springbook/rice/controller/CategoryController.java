package com.springbook.rice.controller;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.service.CategoryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class CategoryController {
    @Autowired
    CategoryFoodService categoryFoodService;
    @RequestMapping("/food-category")
    public String foodCategory(Model model){
        model.addAttribute("categorys",categoryFoodService.selectAll());
        return "food-category";
    }

    @RequestMapping("/dwon")
    @ResponseBody
    public JSONResult dwon(String category){
        return categoryFoodService.categoryDwon(category);
    }

    @RequestMapping("/up")
    @ResponseBody
    public JSONResult up(String category){
        return categoryFoodService.categoryUp(category);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JSONResult delete(String category){
        return categoryFoodService.categoryDelete(category);
    }

    @RequestMapping("/categoryAdd")
    @ResponseBody
    public JSONResult categoryAdd(String category){
        System.out.println(category);
        return categoryFoodService.categoryAdd(category);
    }

}
