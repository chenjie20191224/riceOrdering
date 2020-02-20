package com.springbook.rice.common.utils;

public class JSONPhotos {
    private String url="./images/banner.png";
    private String msg="错误";
    public JSONPhotos(boolean success,String msg){
        super();
        this.url=url;
        this.msg=msg;
    }
    public JSONPhotos(String msg){
        super();
        this.msg=msg;
    }
    public JSONPhotos(){
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
