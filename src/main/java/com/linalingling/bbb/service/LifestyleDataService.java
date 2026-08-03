package com.linalingling.bbb.service;

import com.linalingling.bbb.entity.LifestyleData;
import com.linalingling.bbb.repository.LifestyleDataRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.linalingling.bbb.entity.User;
import java.time.LocalDate;
import java.util.Optional;
import java.math.BigDecimal;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LifestyleDataService {

    private final LifestyleDataRepository lifestyleDataRepository;

    public LifestyleData recordDailyData(Long userId, LocalDate recordDate,
                                         BigDecimal weight, BigDecimal height,
                                         String exerciseType, BigDecimal exerciseDuration,
                                         LifestyleData.FatigueLevel fatigueLevel,
                                         Boolean isRelaxed, String relaxActivity,
                                         String dietNote){

        Optional<LifestyleData>existing = lifestyleDataRepository.findByUserIdAndRecordDate(
                userId, recordDate);

        LifestyleData data;
        if (existing.isPresent()){
            data = existing.get();
        }else{
            User user = new User();
            user.setId(userId);
            data = LifestyleData.builder()
                    .user(user)
                    .recordDate(recordDate)
                    .build();}

        if(weight != null) data.setWeight(weight);
        if(height != null) data.setHeight(height);
        if(exerciseType != null) data.setExerciseType(exerciseType);
        if (exerciseDuration != null) data.setExerciseDuration(exerciseDuration);
        if (fatigueLevel != null) data.setFatigueLevel(fatigueLevel);
        if (isRelaxed != null) data.setIsRelaxed(isRelaxed);
        if (relaxActivity != null) data.setRelaxActivity(relaxActivity);
        if (dietNote != null) data.setDietNote(dietNote);

        return lifestyleDataRepository.save(data);}
}

