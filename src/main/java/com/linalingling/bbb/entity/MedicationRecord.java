package com.linalingling.bbb.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "medication_records")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter

public class MedicationRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medical_record_id",nullable = false)
    private MedicalRecord medicalRecord;

    @Column(name = "drug_name")
    private String drugName;

    private String dosage;

    private String frequency;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){createdAt = LocalDateTime.now();}}
