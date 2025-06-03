package com.chatzone.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String avatar;
    private String signature;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public void preInsert() {
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
        if (status == null) {
            status = 1; // 1: 正常, 0: 禁用
        }
        if (nickname == null || nickname.isEmpty()) {
            nickname = username;
        }
    }

    public void preUpdate() {
        updateTime = LocalDateTime.now();
    }
}