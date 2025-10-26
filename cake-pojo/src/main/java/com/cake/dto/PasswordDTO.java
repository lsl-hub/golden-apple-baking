package com.cake.dto;

import lombok.Data;

@Data
public class PasswordDTO {
    //旧密码
    private String oldPassword;
    //新密码
    private String newPassword;
}
