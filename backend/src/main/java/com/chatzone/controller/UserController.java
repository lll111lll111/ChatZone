package com.chatzone.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.chatzone.dto.ApiResponse;
import com.chatzone.dto.LoginRequest;
import com.chatzone.dto.SignupRequest;
import com.chatzone.dto.UpdateUserInfoRequest;
import com.chatzone.entity.User;
import com.chatzone.exception.NotLoginException;
import com.chatzone.service.UserService;
import com.chatzone.session.WebSocketSessionManager;
import com.chatzone.util.ApiUtil;
import com.chatzone.util.DtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<Object> signup(@Validated @RequestBody SignupRequest request) {
        int isSignup = userService.signup(request.getUsername(), request.getPassword(), request.getConfirmPassword(), request.getEmail());
        return ApiUtil.successfulResponse(isSignup);
    }

    @PostMapping("/login")
    public ApiResponse<Object> login(@Validated @RequestBody LoginRequest request) {
        User user = userService.login(request.getUsername(), request.getPassword());
        StpUtil.login(user.getId());
        return ApiUtil.successfulResponse(true);
    }

    @PostMapping("/getUserInfo")
    public ApiResponse<Object> getUserInfo(@RequestBody(required = false) String request) {
        User user;
        if (request == null) {
            if (StpUtil.isLogin()) {
                // 安全获取 Integer 类型登录 ID
                Integer loginId = StpUtil.getLoginIdAsInt();
                user = userService.getUserInfo(loginId);
            } else {
                // 未登录处理逻辑
                throw new NotLoginException();
            }
        } else {
            user = userService.getUserInfoByUsername(request);
        }
        return ApiUtil.successfulResponse(DtoUtil.UsertoGetUserInfoResponse(user));
    }

    @PostMapping("/checkLogin")
    public ApiResponse<Object> checkLogin() {
        if (!StpUtil.isLogin()) {
            throw new NotLoginException();
        }
        return ApiUtil.successfulResponse(true);
    }

    @PostMapping("/logout")
    public ApiResponse<Object> logout() throws IOException {
        if (!StpUtil.isLogin()) {
            throw new NotLoginException();
        } else {
            long id = StpUtil.getLoginIdAsInt();
            StpUtil.logout();
            WebSocketSessionManager webSocketSessionManager = new WebSocketSessionManager();
            webSocketSessionManager.getSessionMap().get(id).close();
        }
        return ApiUtil.successfulResponse(true);
    }

    @PostMapping("/updateUserInfo")
    public ApiResponse<Object> updateUserInfo(@Validated @ModelAttribute UpdateUserInfoRequest request) throws IOException {
        if (!StpUtil.isLogin()) {
            throw new NotLoginException();
        } else {
            int id = StpUtil.getLoginIdAsInt();
            if (request.getAvatar() instanceof MultipartFile)
                userService.updateUserInfo(id, request.getNickname(), request.getAge(), request.getGender(), request.getSignature(), (MultipartFile) request.getAvatar());
            else if (request.getAvatar() instanceof String)
                userService.updateUserInfo(id, request.getNickname(), request.getAge(), request.getGender(), request.getSignature());
        }
        return ApiUtil.successfulResponse(true);
    }
}
