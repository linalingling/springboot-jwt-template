package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.MedicationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MedicationRecordRepository extends JpaRepository<MedicationRecord, Long> {

    List<MedicationRecord> findByMedicalRecordId(Long medicalRecordId);}

