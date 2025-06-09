package com.chatzone.exception;

public class UsernameAlreadyExistsException extends ApiException {
    public UsernameAlreadyExistsException() {
        super(403, "用户名已经存在");
    }
}
