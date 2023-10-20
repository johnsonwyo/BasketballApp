package com.basketballapp.teamservice.controller;

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

import com.basketballapp.teamservice.model.Team;
import com.basketballapp.teamservice.service.TeamService;

@RestController
@RequestMapping(value = "v1/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/{year}/{grade}", method = RequestMethod.GET)
	public ResponseEntity<Team> getTeam(@PathVariable("year") int year,
			@PathVariable("grade") int grade) {

		Team team = teamService.getTeam(year, grade);

		return ResponseEntity.ok(team);
	}

	@PutMapping
	public ResponseEntity<Team> updateTeam(@RequestBody Team request) {
		return ResponseEntity.ok(teamService.updateTeam(request));
	}

	@PostMapping
	public ResponseEntity<Team> createTeam(@RequestBody Team request) {
		return ResponseEntity.ok(teamService.createTeam(request));
	}

	@DeleteMapping(value = "/{year}/{grade}")
	public ResponseEntity<String> deleteTeam(@PathVariable("year") int year,
			@PathVariable("grade") int grade) {
		return ResponseEntity.ok(teamService.deleteTeam(year, grade));
	}
}
