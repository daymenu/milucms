package cn.daymenu.milucms.admin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCodeEnum {
    /**
     * 10000 - 19999 通用错误
     */
    ILLEGAL_PARAMS(10000, "参数非法"),
    SERVER_ERROR(15000, "系统错误"),
    // 用户模块错误
    USER_HAS_EXIST(20000, "用户已存在"),
    USER_NOT_EXIST(20001,"用户不存在");

    private Integer code;
    private String message;
}
