package com.chatzone.entity;

import lombok.Data;

@Data
public class Friend {
    private String username;
    private String nickname;
    private String avatar;
    private int status;
}
