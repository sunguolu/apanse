package com.apanse.icabst.modules.common;

import com.apanse.icabst.modules.enums.ResponseEnum;

/**
 * @program: icabst
 * @Date: 2019/5/26 8:12 PM
 * @Author: Mr.Deng
 * @Description:
 */
public class Messages {

    public Messages() {
    }

    public Messages(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private String code;

    private String message;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static Messages getSuccess(Object data){
        return new Messages(ResponseEnum.ResponseCodeEnum6.SUCCESS.getCode(), ResponseEnum.ResponseCodeEnum6.SUCCESS.getDesc(),data);

    }

    public static  Messages getException(String message, Object data){
        return new Messages(ResponseEnum.ResponseCodeEnum6.FAIL.getCode(), message,data);
    }
    

}
