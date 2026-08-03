package com.linalingling.bbb.dto;

import com.linalingling.bbb.entity.Allergy;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter

public class AllergyRequest{

    @NotNull
    private Long userId;

    @NotNull
    private Long doctorId;

    @NotNull
    private String allergen;

    @NotNull
    private Allergy.SeverityLevel severityLevel;

    private String clinicalNotes;

    private LocalDate diagnosedDate;}