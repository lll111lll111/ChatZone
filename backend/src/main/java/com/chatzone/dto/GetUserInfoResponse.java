package com.chatzone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoResponse {
    private String username;
    private String nickname;
    private String avatar;
    private String email;
    private String signature;
    private String gender;
    private int age;
}
