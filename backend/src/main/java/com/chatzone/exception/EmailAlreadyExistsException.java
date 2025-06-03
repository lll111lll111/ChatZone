package com.chatzone.exception;


public class EmailAlreadyExistsException extends ApiException{
    public EmailAlreadyExistsException() {
        super(404, "邮箱已被注册");
    }
}
