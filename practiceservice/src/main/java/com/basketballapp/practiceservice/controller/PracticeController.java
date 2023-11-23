package com.basketballapp.practiceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basketballapp.practiceservice.model.Practice;
import com.basketballapp.practiceservice.service.PracticeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "v1/practice")
public class PracticeController {

	@Autowired
	private PracticeService practiceService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Practice> getPractice(@PathParam("date") String date,
			@PathParam("grade") int grade) {

		Practice practice = practiceService.getPractice(date, grade);

		return ResponseEntity.ok(practice);
	}

	@PutMapping
	public ResponseEntity<Practice> updatePractice(@RequestBody Practice request) {
		return ResponseEntity.ok(practiceService.updatePractice(request));
	}

	@PostMapping
	public ResponseEntity<Practice> createPractice(@RequestBody Practice request) {
		return ResponseEntity.ok(practiceService.createPractice(request));
	}

	@DeleteMapping
	public ResponseEntity<String> deletePractice(@PathParam("date") String date,
			@PathParam("grade") int grade) {
		return ResponseEntity.ok(practiceService.deletePractice(date, grade));
	}
}
