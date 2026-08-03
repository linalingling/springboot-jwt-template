package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.DataAuthorization;
import com.linalingling.bbb.dto.GrantAuthorizationRequest;
import com.linalingling.bbb.security.UserPrincipal;
import com.linalingling.bbb.service.DataAuthorizationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/authorizations")
@RequiredArgsConstructor
public class DataAuthorizationController {

    private final DataAuthorizationService dataAuthorizationService;

    @PostMapping
    public ResponseEntity<DataAuthorization> grant(@AuthenticationPrincipal UserPrincipal principal,
                                                   @Valid @RequestBody GrantAuthorizationRequest request){
        DataAuthorization result = dataAuthorizationService.grantAuthorization(
                principal.getId(), request.getTargetUserId(),request.getScope());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);}

    @DeleteMapping
    public ResponseEntity<Void> revoke(@AuthenticationPrincipal UserPrincipal principal,
            @RequestParam Long targetUserId,

            @RequestParam DataAuthorization.Scope scope){

        dataAuthorizationService.revokeAuthorization(principal.getId(), targetUserId,scope);
        return ResponseEntity.noContent().build();}
}