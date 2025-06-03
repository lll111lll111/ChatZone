package com.chatzone.exception;

public class WrongLoginInfoException extends ApiException{
    public WrongLoginInfoException(){
        super(405,"用户名或密码错误!");
    }
}
