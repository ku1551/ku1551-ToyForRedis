package com.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.dto.UserRequest;
import com.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> checkLogin(UserRequest loginRequest) {
        
        if (loginRequest.getProvider() == null){
            User user = getUserByEmail(loginRequest.getEmail());
            if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
                return Optional.empty();
            }
            return Optional.ofNullable(user);
        }

        User user = getUserByProvider(loginRequest.getProvider(), loginRequest.getProviderId());
        return Optional.ofNullable(user);
        
    }

    @Override
    public User getUserByProvider(String provider, String providerId) {
        return userRepository.findByProviderAndProviderId(provider, providerId)
        .orElseThrow(()-> new UsernameNotFoundException("User is not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
        .orElseThrow(()-> new UsernameNotFoundException("user is not found"));
    }

    

    
}
