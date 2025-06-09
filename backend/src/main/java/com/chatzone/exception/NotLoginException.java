package com.chatzone.exception;

public class NotLoginException extends ApiException {
    public NotLoginException() {
        super(501, "用户未登录");
    }
}
