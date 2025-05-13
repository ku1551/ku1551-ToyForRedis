package com.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.JwtUtil;
import com.domain.User;
import com.dto.UserRequest;
import com.dto.UserResponse;
import com.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    private JwtUtil jwtUtil;
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest loginRequest){
        
        Optional<User> userOpt = authService.checkLogin(loginRequest);

        if(userOpt.isPresent()){
            User user = userOpt.get();
            String token = jwtUtil.generateToken(user.getEmail());
            UserResponse response = new UserResponse(user);

            return ResponseEntity.ok(Map.of(
                "token", token,
                "user", response
            ));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
        }
    }
}
