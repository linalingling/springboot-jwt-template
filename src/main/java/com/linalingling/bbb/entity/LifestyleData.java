package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "lifestyle_data",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","record_date"}))
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class LifestyleData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "record_date",nullable = false)
    private LocalDate recordDate;

    private BigDecimal weight;
    private BigDecimal height;

    @Column(name = "exercise_type")
    private String exerciseType;

    @Column(name ="exercise_duration")
    private BigDecimal exerciseDuration;

    public enum FatigueLevel{
        MILD,MODERATE,SEVERE}

    @Enumerated(EnumType.STRING)
    @Column(name = "fatigue_level")
    private FatigueLevel fatigueLevel;

    @Column(name = "is_relaxed")
    private Boolean isRelaxed;

    @Column(name = "relax_activity")
    private String relaxActivity;

    @Column(name = "diet_note")
    private String dietNote;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}
}

