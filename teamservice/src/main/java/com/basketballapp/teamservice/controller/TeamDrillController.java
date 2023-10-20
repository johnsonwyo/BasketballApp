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

import com.basketballapp.teamservice.model.TeamDrill;
import com.basketballapp.teamservice.service.TeamDrillService;

@RestController
@RequestMapping(value = "v1/team/drills")
public class TeamDrillController {

	@Autowired
	private TeamDrillService drillService;

	@RequestMapping(value = "/{teamDrillId}", method = RequestMethod.GET)
	public ResponseEntity<TeamDrill> getDrill(@PathVariable("teamDrillId") int drillId) {

		TeamDrill drill = drillService.getTeamDrill(drillId);

		return ResponseEntity.ok(drill);
	}

	@PutMapping(value = "/{year}/{grade}")
	public ResponseEntity<TeamDrill> updateDrill(@PathVariable int year, @PathVariable int grade,
			@RequestBody TeamDrill request) {
		return ResponseEntity.ok(drillService.updateTeamDrill(request, year, grade));
	}

	@PostMapping(value = "/{year}/{grade}")
	public ResponseEntity<TeamDrill> createDrill(@PathVariable int year, @PathVariable int grade,
			@RequestBody TeamDrill request) {
		return ResponseEntity.ok(drillService.createTeamDrill(request, year, grade));
	}

	@DeleteMapping(value = "/{drillId}")
	public ResponseEntity<String> deleteDrill(@PathVariable("drillId") int drillId) {
		return ResponseEntity.ok(drillService.deleteTeamDrill(drillId));
	}
}
