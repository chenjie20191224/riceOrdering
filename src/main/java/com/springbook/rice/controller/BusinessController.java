package com.springbook.rice.controller;

import com.springbook.rice.common.domain.Business;

import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.service.BusinessService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Value;


@Controller
public class BusinessController {
    @Value("${web.upload-path}")
    private String path;
//商家信息更新的项目
    String msg="";

    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    BusinessService businessService;

    @RequestMapping("/business-update")
    public String businessUpdate(Model model) {
//        向前端传递商家信息
        Business business = businessMapper.selectByPrimaryKey(1);
        model.addAttribute("business", business);
        return "business-update";
    }

//修改页面
    @RequestMapping("/business-edit")
    public String businessEdit(Model model, String msg) {
        this.msg = msg;
        model.addAttribute("msg", msg);
        if (msg.equals("营业资质")){
        return "banner-edit";
        }
        return "business-edit";
    }

    //更新商家信息
    @RequestMapping("/businessUpdate")
    public String businessUPdate(String msg,String input) {
        System.out.println(msg+input);
        businessService.updateAttribute(msg, input);
        return "redirect:/business-update";
    }

//轮盘管理
    @RequestMapping("/banner")
    public String banner(Model model) {
        model.addAttribute(businessMapper.selectByPrimaryKey(1));
      return "banner-list";
    }

    //轮盘图更新
    @RequestMapping("/bannerEdit")
    public String bannerEdit(String banners,String src,Model model) {
        model.addAttribute("src",src);
        this.msg=banners;
        return "banner-edit";

    }

//上传图片到本地
    @PostMapping("/upload")
    @ResponseBody
    public JSONPhotos filesUpload(@RequestParam("file") MultipartFile file) {
       return businessService.uploadPhotos(file);
    }

//    图片提交到数据库
    @RequestMapping("/photosSubmit")
    @ResponseBody
    public JSONResult photosSubmit() {
      return businessService.photosSubmit(msg);
    }



}
