package com.chatzone.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.chatzone.dto.ApiResponse;
import com.chatzone.entity.Friend;
import com.chatzone.entity.PrivateChat;
import com.chatzone.entity.PrivateMessage;
import com.chatzone.exception.NotLoginException;
import com.chatzone.service.FriendService;
import com.chatzone.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping("getFriendList")
    public ApiResponse<Object> getFriendList() {
        List<Friend> friendList;
        if (StpUtil.isLogin()) {
            friendList = friendService.getFriendList(StpUtil.getLoginIdAsInt());
        } else {
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(friendList);
    }

    @PostMapping("addFriend")
    public ApiResponse<Object> addFriend(@RequestBody String request) throws IOException {
        if (StpUtil.isLogin()) {
            friendService.addFriend(StpUtil.getLoginIdAsInt(), request);
        } else {
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(null);
    }

    @PostMapping("deleteFriend")
    public ApiResponse<Object> deleteFriend(@RequestBody String request) throws IOException {
        if (StpUtil.isLogin()) {
            friendService.deleteFriend(StpUtil.getLoginIdAsInt(), request);
        } else {
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(null);
    }

    @PostMapping("getPrivateChatList")
    public ApiResponse<Object> getPrivateChatList(){
        List<PrivateChat> privateChatList;
        if (StpUtil.isLogin()) {
            //获取列表
            privateChatList = friendService.getPrivateChatList(StpUtil.getLoginIdAsInt());
        } else {
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(privateChatList);
    }
}
