package com.linalingling.bbb.dto;

import com.linalingling.bbb.entity.DataAuthorization;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter @Setter
public class GrantAuthorizationRequest {

    @NotNull
    private Long patientUserId;

    @NotNull
    private Long targetUserId;

    @NotNull
    private DataAuthorization.Scope scope;
}
