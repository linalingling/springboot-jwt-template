package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.MedicalRecord;
import com.linalingling.bbb.security.UserPrincipal;
import com.linalingling.bbb.service.MedicalRecordService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseEntity<List<MedicalRecord>> getPatientRecords(@AuthenticationPrincipal UserPrincipal principal,
            @PathVariable Long patientId)
            {

        List<MedicalRecord> records = medicalRecordService.getPatientMedicalRecords(principal.getId(), 	patientId);
        return ResponseEntity.ok(records);
    }
}