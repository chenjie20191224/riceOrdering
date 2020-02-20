package com.springbook.rice.service.impl;

import com.springbook.rice.common.domain.Business;
import com.springbook.rice.common.domain.BusinessExample;
import com.springbook.rice.common.utils.FileUtils;
import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import com.springbook.rice.mapper.BusinessMapper;
import com.springbook.rice.mapper.FoodMapper;
import com.springbook.rice.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    FoodMapper foodMapper;

    MultipartFile file;

//    确认轮播图和营业资质是否选择（上传）
    Boolean photosConfirm=false;

    BusinessExample businessExample=new BusinessExample();

//    更新商家信息
    public int updateAttribute(String attribute,String newAttribute){
        Business business=new Business();
        switch (attribute){
            case "商家名称": business.setBusinessName(newAttribute);break;
            case "起送": business.setStartDelivery(Integer.valueOf(newAttribute));break;
            case "配送": business.setDeliveryFee(Integer.valueOf(newAttribute));break;
            case "配送时间": business.setDeliveryTime(newAttribute);break;
            case "商家活动": business.setActivity(newAttribute);break;
            case "商家地址": business.setAddress(newAttribute);break;
            case "配送范围": business.setDeliveryScope(Integer.valueOf(newAttribute));break;
            case "配送服务": business.setDeliveryService(newAttribute);break;
            case "商家电话": business.setTelephone(newAttribute);break;
            case "包装费": BigDecimal bd=new BigDecimal(newAttribute);business.setPackFee(bd);break;
            case "送达时间": business.setServiceTime(Integer.valueOf(newAttribute));break;
        }

        businessExample.createCriteria().andBusinessIdEqualTo(1);

        return businessMapper.updateByExampleSelective(business,businessExample);
    }

//    上传图片
    public JSONPhotos uploadPhotos(MultipartFile file){
        this.file=file;
        this.photosConfirm=true;
       return FileUtils.uploadPhotos(file);
    }

//    图片提交到数据库
    public JSONResult photosSubmit(String banners){
        JSONResult jsonResult=new JSONResult();
        if (!this.photosConfirm){
            jsonResult.setSuccess(false);
            return jsonResult;
        }else {
            System.out.println("上传图片");
            jsonResult.setSuccess(true);
            this.photosConfirm=false;
        }
         Business business=new Business();
        switch (banners){
            case "营业资质":business.setBusinessLicense("/photos/"+file.getOriginalFilename());break;
            case "chart1":business.setChart1("/photos/"+file.getOriginalFilename());break;
            case "chart2":business.setChart2("/photos/"+file.getOriginalFilename());break;
            case "chart3":business.setChart3("/photos/"+file.getOriginalFilename());break;
        }
        businessMapper.updateByExampleSelective(business,businessExample);
        return jsonResult;
    }


}
