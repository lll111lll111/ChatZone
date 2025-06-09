package com.chatzone.exception;

public class FriendshipNotExitsException extends ApiException {
    public FriendshipNotExitsException() {
        super(602, "好友关系不存在");
    }
}
