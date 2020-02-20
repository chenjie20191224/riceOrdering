package com.springbook.rice.common.utils;

import com.springbook.rice.common.domain.Admin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;

public class Session {
    public static HttpSession getSession(){
      //session默认30分钟
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
       //设置session保存时间24小时 =24*60*60=86400秒，
        session.setMaxInactiveInterval(24*60*60);
        return session;
    }
    public static Admin getCurrent(){
        return (Admin) getSession().getAttribute("admin");
    }
    public static void setCurrent(Admin admin){
        getSession().setAttribute("admin",admin);
    }
    public static void clearSession(){
        getSession().removeAttribute("admin");
        getSession().removeAttribute("business");

    }
     public static void addAttribute(String s,Object o){
        getSession().setAttribute(s,o);
     }

}
