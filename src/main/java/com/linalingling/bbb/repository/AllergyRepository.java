package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {

    @Query("SELECT a FROM Allergy a JOIN FETCH a.user JOIN FETCH a.userOfDoctor WHERE a.user.id = :userId")
    List<Allergy> findByUserId(@Param("userId") Long userId);}