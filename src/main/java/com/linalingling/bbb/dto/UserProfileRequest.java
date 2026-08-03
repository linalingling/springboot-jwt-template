package com.linalingling.bbb.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class UserProfileRequest{

    @NotNull
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthDate;}