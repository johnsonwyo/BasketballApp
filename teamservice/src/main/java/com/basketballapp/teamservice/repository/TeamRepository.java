package com.basketballapp.teamservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.teamservice.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query("SELECT t FROM Team t WHERE t.year = ?1 AND t.grade = ?2")
    Team findByYearAndGrade(int year, int grade);

}
