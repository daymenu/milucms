package cn.daymenu.milucms.admin.common.commons;

import cn.daymenu.milucms.admin.common.enums.ApiCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResultCommon<T> {
    private int code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return ApiCodeEnum.SUCCESS.getCode() == this.code;
    }

    public static <T> ApiResultCommon<T> createResult(ApiCodeEnum apiCodeEnum) {
        return createResult(apiCodeEnum.getCode(), apiCodeEnum.getMessage());
    }


    public static <T> ApiResultCommon<T> createResult(int code, String message) {
        return new ApiResultCommon<>(code, message, null);
    }

    public static ApiResultCommon SUCCESS() {
        return new ApiResultCommon<>(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ApiResultCommon<T> SUCCESS(T data) {
        return new ApiResultCommon<>(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMessage(), data);
    }

    public static ApiResultCommon FAILED() {
        return new ApiResultCommon<>(ApiCodeEnum.FAILED.getCode(), ApiCodeEnum.FAILED.getMessage(), null);
    }

    public static <T> ApiResultCommon<T> FAILD(T data) {
        return new ApiResultCommon<>(ApiCodeEnum.FAILED.getCode(), ApiCodeEnum.FAILED.getMessage(), data);
    }

    public static ApiResultCommon FAILED(String message) {
        return new ApiResultCommon<>(ApiCodeEnum.FAILED.getCode(), message, null);
    }

    public static ApiResultCommon FAILED(ApiCodeEnum apiCodeEnum) {
        return new ApiResultCommon<>(apiCodeEnum.getCode(), apiCodeEnum.getMessage(), null);
    }
}
