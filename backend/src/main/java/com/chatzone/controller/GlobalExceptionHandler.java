package com.chatzone.controller;

import com.chatzone.dto.ApiResponse;
import com.chatzone.exception.ApiException;
import com.chatzone.exception.UserNotFoundException;
import com.chatzone.util.ApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ApiResponse<Void> handleApiException(ApiException e) {
        return ApiUtil.failedResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ApiResponse<Object> handleOtherException(Exception e) {
        logger.error(STR."发生错误: \{e}");
        return ApiUtil.failedResponse(500, "服务器繁忙，请稍后再试");
    }
}
