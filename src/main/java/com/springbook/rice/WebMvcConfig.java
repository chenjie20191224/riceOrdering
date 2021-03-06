package com.springbook.rice;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photos/**").addResourceLocations("file:/D:/工作文档/IDEA/Photos/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
