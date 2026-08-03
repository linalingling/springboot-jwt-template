package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.LifestyleData;
import com.linalingling.bbb.dto.LifestyleDataRequest;
import com.linalingling.bbb.service.LifestyleDataService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.linalingling.bbb.security.UserPrincipal;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lifestyle-data")


public class LifestyleDataController{

    private final LifestyleDataService lifestyleDataService;

    @PutMapping
    public ResponseEntity<LifestyleData> upsert(@AuthenticationPrincipal UserPrincipal principal,
                                                @Valid @RequestBody LifestyleDataRequest 	request){

        LifestyleData result = lifestyleDataService.recordDailyData(

                principal.getId(), request.getRecordDate(),request.getWeight(),request.getHeight(),
                request.getExerciseType(),request.getExerciseDuration(),request.getFatigueLevel(),
                request.getIsRelaxed(),request.getRelaxActivity(),request.getDietNote());

        return ResponseEntity.ok(result);}}