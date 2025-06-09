package com.chatzone.exception;

public class FriendshipAlreadyExistsException extends ApiException {
    public FriendshipAlreadyExistsException() {
        super(601, "你们已经是好友了");
    }
}
