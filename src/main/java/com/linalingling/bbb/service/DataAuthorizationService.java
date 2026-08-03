package com.linalingling.bbb.service;

import com.linalingling.bbb.entity.DataAuthorization;
import com.linalingling.bbb.repository.DataAuthorizationRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.linalingling.bbb.entity.User;
import org.springframework.security.access.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Transactional
public class DataAuthorizationService{

    private final DataAuthorizationRepository dataAuthorizationRepository;

    public void checkAuthorization(Long targetUserId, Long patientUserId, DataAuthorization.Scope scope){

        boolean authorized = dataAuthorizationRepository
                .findByUserIdAndTargetUserIdAndScopeAndRevokedAtIsNull(patientUserId,targetUserId,scope)
                .isPresent();

        if(!authorized){
            throw new AccessDeniedException("沒有授權存取此資料!");}
    }

    public DataAuthorization grantAuthorization(Long patientUserId, Long targetUserId, DataAuthorization.Scope scope ){
        User patient = new User();
        patient.setId(patientUserId);

        User target = new User();
        target.setId(targetUserId);

        DataAuthorization authorization = DataAuthorization.builder()
                .user(patient)
                .targetUser(target)
                .scope(scope)
                .build();

        return dataAuthorizationRepository.save(authorization);}

    public void revokeAuthorization(Long targetUserId, Long patientUserId,DataAuthorization.Scope scope){

        Optional<DataAuthorization> existing = dataAuthorizationRepository
                .findByUserIdAndTargetUserIdAndScopeAndRevokedAtIsNull(patientUserId, targetUserId, scope);

        if(existing.isPresent()){
            DataAuthorization authorization = existing.get();
            authorization.setRevokedAt(LocalDateTime.now());
            dataAuthorizationRepository.save(authorization);

        }else{
            throw new AccessDeniedException("找不到有效授權,無法撤銷");}
    }
}
