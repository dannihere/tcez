package com.tcezhan.tcez.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    USER_NOT_EXIT(1,"用户不存在"),
    PASSWORD_WRONG(2,"密码错误")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
