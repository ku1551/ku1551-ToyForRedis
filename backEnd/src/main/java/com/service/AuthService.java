package com.service;

import java.util.Optional;

import com.domain.User;
import com.dto.UserRequest;

public interface AuthService {
    Optional<User> checkLogin(UserRequest loginRequest);

    User getUserByProvider(String provider, String providerId);

    User getUserByEmail(String email);
}
