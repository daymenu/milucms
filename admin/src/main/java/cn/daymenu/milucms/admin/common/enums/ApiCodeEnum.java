package cn.daymenu.milucms.admin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiCodeEnum {
    SUCCESS(200, ""),
    FAILED(10000, "网络异常"),
    PARAM_ERROR(11000, "接口参数错误"),
    URL_NOT_EXIST(12000, "接口不存在"),
    RPC_FAIL(13000, "调用服务异常");

    private int code;
    private String message;
}
