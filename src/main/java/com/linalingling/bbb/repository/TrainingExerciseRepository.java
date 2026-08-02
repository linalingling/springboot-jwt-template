package com.linalingling.bbb.repository;

import com.linalingling.bbb.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;




public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {


    List<TrainingExercise> findByTrainingRecordId(Long trainingRecordId);}


