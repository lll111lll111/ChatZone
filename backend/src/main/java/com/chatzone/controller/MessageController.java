package com.chatzone.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.chatzone.dto.ApiResponse;
import com.chatzone.entity.PrivateMessage;
import com.chatzone.exception.NotLoginException;
import com.chatzone.exception.UserNotFoundException;
import com.chatzone.service.MessageService;
import com.chatzone.service.UserService;
import com.chatzone.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @PostMapping("/getPrivateChatHistory")
    public ApiResponse<Object> getPrivateMessage(@RequestBody String friendUsername){
        List<PrivateMessage> privateMessages;
        Integer friendId = userService.getIdByUserName(friendUsername);
        if(StpUtil.isLogin()){
            if(friendId != null){
                privateMessages = messageService.getPrivateMessages(StpUtil.getLoginIdAsInt(),friendId);
            }else{
                throw new UserNotFoundException();
            }
        }else{
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(privateMessages);
    }
}
