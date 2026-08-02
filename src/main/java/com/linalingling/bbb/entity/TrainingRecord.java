package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "training_records")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class TrainingRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "coach_id",nullable = false)
    private User coach;

    @Column(name = "training_date", nullable = false)
    private LocalDate trainingDate;

    @Column(name = "coach_notes",columnDefinition = "TEXT")
    private String coachNotes;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}

    @OneToMany(mappedBy = "trainingRecord", cascade = CascadeType.ALL)
    @Builder.Default
    private List<TrainingExercise> exercises = new ArrayList<>();}


