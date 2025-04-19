package com.service;

import com.dto.LoginRequest;

public interface AuthService {
    boolean checkLogin(LoginRequest loginRequest);
}
