package com.chatzone.dto;

import com.chatzone.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    /**
     * 用户信息
     */
    private User user;
}