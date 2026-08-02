package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.TrainingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;




public interface TrainingRecordRepository extends JpaRepository<TrainingRecord, Long> {


    List<TrainingRecord> findByUserId(Long userId);}

