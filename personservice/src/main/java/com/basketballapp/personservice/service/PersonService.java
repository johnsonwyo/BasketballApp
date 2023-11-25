package com.basketballapp.personservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.personservice.config.ServiceConfig;
import com.basketballapp.personservice.model.Person;
import com.basketballapp.personservice.repository.PersonRepository;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@Service
public class PersonService {

	@Autowired
	MessageSource messages;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	ServiceConfig config;

	@Bulkhead(name = "bulkheadService")
	public Person getPerson(String firstName, String lastName) {
		Person person = personRepository.findByName(firstName, lastName);
		if (null == person) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("person.search.error.message", null, null), firstName, lastName));
		}
		return person;
	}

	public Person createPerson(Person person) {
		personRepository.save(person);

		return person;
	}

	public Person updatePerson(Person person) {
		this.deletePerson(person.getFirstName(), person.getLastName());
		personRepository.save(person);

		return person;
	}

	public String deletePerson(String firstName, String lastName) {
		Person person = personRepository.findByName(firstName, lastName);
		personRepository.delete(person);
		return "Person: " + firstName + " " + lastName + " was deleted.";

	}
}
