package com.basketballapp.practiceservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.practiceservice.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}