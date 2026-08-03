package com.linalingling.bbb.dto;

import com.linalingling.bbb.entity.LifestyleData;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.math.BigDecimal;

@Getter @Setter

public class LifestyleDataRequest{



    @NotNull
    private LocalDate recordDate;

    private BigDecimal weight;
    private BigDecimal height;
    private String exerciseType;
    private BigDecimal exerciseDuration;
    private LifestyleData.FatigueLevel fatigueLevel;
    private Boolean isRelaxed;
    private String relaxActivity;
    private String dietNote;
}