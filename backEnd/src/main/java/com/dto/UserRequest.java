package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String email;
    private String provider;
    private String providerId;
    private String name;
    private String password;
}
