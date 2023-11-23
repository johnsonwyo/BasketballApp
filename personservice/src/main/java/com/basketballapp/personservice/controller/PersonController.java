package com.basketballapp.personservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basketballapp.personservice.model.Person;
import com.basketballapp.personservice.service.PersonService;

@RestController
@RequestMapping(value = "v1/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<Person> getperson(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		Person person = personService.getPerson(firstName, lastName);

		return ResponseEntity.ok(person);
	}

	@PutMapping
	public ResponseEntity<Person> updateperson(@RequestBody Person request) {
		return ResponseEntity.ok(personService.updatePerson(request));
	}

	@PostMapping
	public ResponseEntity<Person> createperson(@RequestBody Person request) {
		return ResponseEntity.ok(personService.createPerson(request));
	}

	@DeleteMapping(value = "/{firstName}/{lastName}")
	public ResponseEntity<String> deleteperson(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ResponseEntity.ok(personService.deletePerson(firstName, lastName));
	}
}
