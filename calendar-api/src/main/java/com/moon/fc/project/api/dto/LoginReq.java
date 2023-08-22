package com.moon.fc.project.api.dto;

import lombok.Data;

@Data
public class LoginReq {
    private final String email;
    private final String password;
}
