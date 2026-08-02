package com.linalingling.bbb.service;

import com.linalingling.bbb.entity.MedicalRecord;
import com.linalingling.bbb.entity.DataAuthorization;
import com.linalingling.bbb.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;



@Service
@RequiredArgsConstructor
public class MedicalRecordService{

    private final MedicalRecordRepository medicalRecordRepository;
    private final DataAuthorizationService dataAuthorizationService;

    public List<MedicalRecord> getPatientMedicalRecords(Long doctorId, Long patientId){

        dataAuthorizationService.checkAuthorization(doctorId,patientId,DataAuthorization.Scope.MEDICAL);
        return medicalRecordRepository.findByUserId(patientId);} }