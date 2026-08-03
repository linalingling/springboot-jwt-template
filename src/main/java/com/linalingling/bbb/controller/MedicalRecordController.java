package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.MedicalRecord;
import com.linalingling.bbb.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor

public class MedicalRecordController{

    private final MedicalRecordService medicalRecordService;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getPatientRecords(
            @PathVariable Long patientId,
            @RequestParam Long doctorId){

        List<MedicalRecord> records = medicalRecordService.getPatientMedicalRecords(doctorId, 	patientId);
        return ResponseEntity.ok(records);
    }
}