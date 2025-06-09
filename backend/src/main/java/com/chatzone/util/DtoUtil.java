package com.chatzone.util;

import com.chatzone.dto.GetUserInfoResponse;
import com.chatzone.entity.User;

public class DtoUtil {
    public static GetUserInfoResponse UsertoGetUserInfoResponse(User user) {
        GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
        getUserInfoResponse.setUsername(user.getUsername());
        getUserInfoResponse.setNickname(user.getNickname());
        getUserInfoResponse.setAvatar(user.getAvatar());
        getUserInfoResponse.setEmail(user.getEmail());
        getUserInfoResponse.setSignature(user.getSignature());
        getUserInfoResponse.setAge(user.getAge());
        getUserInfoResponse.setGender(user.getGender());
        return getUserInfoResponse;
    }
}
