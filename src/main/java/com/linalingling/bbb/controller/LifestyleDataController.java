package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.LifestyleData;
import com.linalingling.bbb.dto.LifestyleDataRequest;
import com.linalingling.bbb.service.LifestyleDataService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lifestyle-data")


public class LifestyleDataController{

    private final LifestyleDataService lifestyleDataService;

    @PutMapping
    public ResponseEntity<LifestyleData> upsert(@Valid @RequestBody LifestyleDataRequest 	request){

        LifestyleData result = lifestyleDataService.recordDailyData(

                request.getUserId(),request.getRecordDate(),request.getWeight(),request.getHeight(),
                request.getExerciseType(),request.getExerciseDuration(),request.getFatigueLevel(),
                request.getIsRelaxed(),request.getRelaxActivity(),request.getDietNote());

        return ResponseEntity.ok(result);}}