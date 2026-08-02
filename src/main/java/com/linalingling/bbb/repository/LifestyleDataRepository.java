package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.LifestyleData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface LifestyleDataRepository extends JpaRepository<LifestyleData, Long> {

    Optional<LifestyleData> findByUserIdAndRecordDate(Long userId, LocalDate recordDate);
    List<LifestyleData> findByUserId(Long userId);}