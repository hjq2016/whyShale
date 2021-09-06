package com.hjq.whyshare.commons.pojo.dto;

/**
 * @Author: zlt
 */
public enum CodeEnum {
    SUCCESS(0),
    ERROR(1),
    LOGIN_ERROR(2);
    ;

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
