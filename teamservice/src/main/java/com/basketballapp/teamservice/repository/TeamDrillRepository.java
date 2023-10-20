package com.basketballapp.teamservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.teamservice.model.TeamDrill;

@Repository
public interface TeamDrillRepository extends CrudRepository<TeamDrill, Integer> {

}