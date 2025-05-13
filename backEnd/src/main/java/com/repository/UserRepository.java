package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
    // OAuth 로그인 시 유저 조회용 (provider + providerId 기준)
    Optional<User> findByProviderAndProviderId(String provider, String providerId);
    // 이메일로 유저 조회
    Optional<User> findByEmail(String email);
}
