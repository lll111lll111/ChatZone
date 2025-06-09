package com.chatzone.exception;

public class FailedToSignupException extends ApiException {
    public FailedToSignupException() {
        super(402, "注册失败");
    }
}
