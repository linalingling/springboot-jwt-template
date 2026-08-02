package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "data_authorizations")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class DataAuthorization{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="target_user_id",nullable = false)
    private User targetUser;

    public enum Scope{
        MEDICAL,LIFESTYLE,COACH}

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Scope scope;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;


    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}}
