package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.UserProfile;
import com.linalingling.bbb.dto.UserProfileRequest;
import com.linalingling.bbb.service.UserProfileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor

public class UserProfileController{

    private final UserProfileService userProfileService;

    @PutMapping
    public ResponseEntity<UserProfile> upsert(@Valid @RequestBody UserProfileRequest 	request){

        UserProfile result = userProfileService.createOrUpdateProfile(
                request.getUserId(),request.getName(),request.getBirthDate());

        return ResponseEntity.ok(result);}}