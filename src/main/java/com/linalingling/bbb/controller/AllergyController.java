package com.linalingling.bbb.controller;

import com.linalingling.bbb.entity.Allergy;
import com.linalingling.bbb.dto.AllergyRequest;
import com.linalingling.bbb.service.AllergyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/allergies")
@RequiredArgsConstructor

public class AllergyController{

    private final AllergyService allergyService;

    @PostMapping
    public ResponseEntity<Allergy> create(@Valid @RequestBody AllergyRequest request){

        Allergy result = allergyService.createAllergy(
                request.getUserId(),request.getDoctorId(),request.getAllergen(),request.getSeverityLevel(),request.getClinicalNotes(),request.getDiagnosedDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);}

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Allergy>> getPatientAllergies(@PathVariable Long patientId){

        List<Allergy> allergies = allergyService.getPatientAllergies(patientId);
        return ResponseEntity.ok(allergies);}}