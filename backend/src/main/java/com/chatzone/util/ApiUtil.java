package com.chatzone.util;

import com.chatzone.dto.ApiResponse;
import org.springframework.http.HttpStatus;

public class ApiUtil {
    /**
     * 用户成功操作方法
     *
     * @param data 后端返回给前端的数据
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> successfulResponse(T data) {
        return new ApiResponse<>(200, data, "操作成功");
    }

    /**
     * 异常处理方法
     *
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> failedResponse(int code, String message) {
        return new ApiResponse<>(code, null, message);
    }

    /**
     * 用于快速生成“用户未登录”的返回数据
     *
     * @return ResponseEntity，可直接作为Controller方法中的返回值
     */
    public static <T> ApiResponse<T> unauthorizedResponse() {
        return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), null, "用户未登录");
    }
}
