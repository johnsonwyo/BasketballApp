package com.basketballapp.personservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.personservice.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.firstName = ?1 AND p.lastName = ?2")
    Person findByName(String firstName, String lastName);

}
