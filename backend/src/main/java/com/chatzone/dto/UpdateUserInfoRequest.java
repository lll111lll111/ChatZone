package com.chatzone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserInfoRequest {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 1, max = 16, message = "用户名长度必须在1-16之间")
    private String nickname;

    private int age;

    @NotBlank(message = "性别不能为空")
    private String gender;

    @NotBlank(message = "个性签名不能为空")
    private String signature;

    private Object avatar;
}
