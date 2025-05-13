package com.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User {
  // PK
  @Column(nullable = false)
  private String id;
  // Oauth path
  private String provider;
  // OAuth ID
  private String providerId;
  // 이메일
  private String email;
  //비밀번호
  private String password;
  // 이름
  @Column(nullable = false)
  private String name;
  // 역할
  @Column(nullable = false)
  private String role;
  // 생성시간
  @Column(nullable = false)
  private LocalDate createdAt;
  // 수정시간
  @Column(nullable = false)
  private LocalDate updatedAt;
}
