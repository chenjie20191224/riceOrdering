package com.springbook.rice.service;

import com.springbook.rice.common.utils.JSONPhotos;
import com.springbook.rice.common.utils.JSONResult;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessService {
     int updateAttribute(String attribute,String newAttribute);
     JSONPhotos uploadPhotos(MultipartFile file);
     JSONResult photosSubmit(String banners);

}
