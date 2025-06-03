package com.chatzone.exception;

public class InvalidCharException extends ApiException{
    public InvalidCharException(){
        super(1001,"输入含有非法字符!只允许使用数字、字母或下划线");
    }
}
