package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.DataAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;



public interface DataAuthorizationRepository extends JpaRepository<DataAuthorization, Long> {

    Optional<DataAuthorization> findByUserIdAndTargetUserIdAndScopeAndRevokedAtIsNull(Long userId, Long targetUserId, DataAuthorization.Scope scope);

    List<DataAuthorization> findByUserId(Long userId);}
