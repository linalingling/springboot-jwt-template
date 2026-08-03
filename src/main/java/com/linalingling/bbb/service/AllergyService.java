package com.linalingling.bbb.service;

import com.linalingling.bbb.entity.Allergy;
import com.linalingling.bbb.entity.User;
import com.linalingling.bbb.repository.AllergyRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AllergyService{

    private final AllergyRepository allergyRepository;

    public List<Allergy> getPatientAllergies (Long userId){
        return allergyRepository.findByUserId(userId);}

    public Allergy createAllergy(Long userId, Long diagnosedByDoctorId, String allergen,
                                 Allergy.SeverityLevel severityLevel, String 							clinicalNotes, LocalDate diagnosedDate){

        User user = new User();
        user.setId(userId);

        User doctor = new User();
        doctor.setId(diagnosedByDoctorId);

        Allergy allergy = Allergy.builder()
                .user(user)
                .userOfDoctor(doctor)
                .allergen(allergen)
                .severityLevel(severityLevel)
                .clinicalNotes(clinicalNotes)
                .diagnosedDate(diagnosedDate)
                .build();

        return allergyRepository.save(allergy);}}