package com.basketballapp.practiceservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.practiceservice.model.Practice;

@Repository
public interface PracticeRepository extends CrudRepository<Practice, Integer> {

    @Query("SELECT p FROM Practice p WHERE p.date = ?1 AND p.grade = ?2")
    Practice findByDateAndGrade(String date, int grade);

}
