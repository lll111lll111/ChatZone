package com.chatzone.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.chatzone.dto.ApiResponse;
import com.chatzone.dto.LoginRequest;
import com.chatzone.dto.LoginResponse;
import com.chatzone.dto.RegisterRequest;
import com.chatzone.entity.User;
import com.chatzone.service.UserService;
import com.chatzone.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<Object> signup(@Validated @RequestBody RegisterRequest request) {
        User user = userService.signup(request.getUsername(), request.getPassword(), request.getConfirmPassword(),request.getEmail());
        return ApiUtil.successfulResponse(user);
    }

    @PostMapping("/login")
    public ApiResponse<Object> login(@Validated @RequestBody LoginRequest request) {
        User user = userService.login(request.getUsername(),request.getPassword());
        StpUtil.login(user.getId());
        return ApiUtil.successfulResponse(user);
    }
}