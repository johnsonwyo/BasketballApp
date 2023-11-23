package com.basketballapp.playermetricservice.controller;

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

import com.basketballapp.playermetricservice.model.Drill;
import com.basketballapp.playermetricservice.service.DrillService;

@RestController
@RequestMapping(value = "v1/drills")
public class DrillController {

	@Autowired
	private DrillService drillService;

	@RequestMapping(value = "/{drillId}", method = RequestMethod.GET)
	public ResponseEntity<Drill> getDrill(@PathVariable("drillId") int drillId) {

		Drill drill = drillService.getDrill(drillId);

		return ResponseEntity.ok(drill);
	}

	@PutMapping(value = "/{firstName}/{lastName}")
	public ResponseEntity<Drill> updateDrill(@PathVariable String firstName, @PathVariable String lastName,
			@RequestBody Drill request) {
		return ResponseEntity.ok(drillService.updateDrill(request, firstName, lastName));
	}

	@PostMapping(value = "/{firstName}/{lastName}")
	public ResponseEntity<Drill> createDrill(@PathVariable String firstName, @PathVariable String lastName,
			@RequestBody Drill request) {
		return ResponseEntity.ok(drillService.createDrill(request, firstName, lastName));
	}

	@DeleteMapping(value = "/{drillId}")
	public ResponseEntity<String> deleteDrill(@PathVariable("drillId") int drillId) {
		return ResponseEntity.ok(drillService.deleteDrill(drillId));
	}
}
