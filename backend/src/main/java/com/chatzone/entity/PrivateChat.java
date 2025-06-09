package com.chatzone.entity;

import lombok.Data;

@Data
public class PrivateChat {
    private String username;
    private String nickname;
    private String avatar;
    private String content;
}
