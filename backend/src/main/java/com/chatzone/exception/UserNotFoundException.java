package com.chatzone.exception;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super(401, "用户不存在");
    }
}
