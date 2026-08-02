package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
@Table(name = "training_exercises")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class TrainingExercise{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_record_id",nullable = false)
    private TrainingRecord trainingRecord;

    @Column(name = "exercise_name",nullable = false)
    private String exerciseName;

    @Column(nullable = false)
    private Integer sets;

    @Column(nullable =false)
    private Integer reps;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}}
