package com.basketballapp.playermetricservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.playermetricservice.model.Drill;

@Repository
public interface DrillRepository extends CrudRepository<Drill, Integer> {

}