package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profile")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserProfile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //主鍵

    @OneToOne
    @JoinColumn(name="user_id",nullable = false, unique = true)
    private User user;

    @Column (nullable = false)
    private String name;

    @Column (name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}}