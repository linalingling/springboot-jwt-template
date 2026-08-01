package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "allergies")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class Allergy{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "diagnosed_by",nullable = false)
    private User userOfDoctor;

    @Column(, nullable = false)
    private String allergen;

    public enum SeverityLevel{
        MILD,MODERATE,SEVERE
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level",nullable = false)
    private SeverityLevel severityLevel;

    @Column(name = "clinical_notes")
    private String clinicalNotes;

    @Column(name = "diagnosed_date")
    private LocalDate diagnosedDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}
}
