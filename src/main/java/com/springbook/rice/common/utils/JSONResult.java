package com.springbook.rice.common.utils;


public class JSONResult {
    private boolean success=false;
    private String msg="错误";
    public JSONResult(boolean success,String msg){
        super();
        this.success=success;
        this.msg=msg;
    }
    public JSONResult(String msg){
        super();
        this.msg=msg;
    }
    public JSONResult(){
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
