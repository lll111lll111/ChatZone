package com.chatzone.exception;

public class SlefFriendException extends ApiException {
    public SlefFriendException() {
        super(603, "不能添加自己为好友");
    }
}
