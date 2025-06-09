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
    private int age;
    private String gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}