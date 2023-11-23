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

import com.basketballapp.playermetricservice.model.Player;
import com.basketballapp.playermetricservice.service.PlayerService;

@RestController
@RequestMapping(value = "v1/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<Player> getplayer(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		Player player = playerService.getPlayer(firstName, lastName);

		return ResponseEntity.ok(player);
	}

	@PutMapping
	public ResponseEntity<Player> updateplayer(@RequestBody Player request) {
		return ResponseEntity.ok(playerService.updatePlayer(request));
	}

	@PostMapping
	public ResponseEntity<Player> createplayer(@RequestBody Player request) {
		return ResponseEntity.ok(playerService.createPlayer(request));
	}

	@DeleteMapping(value = "/{firstName}/{lastName}")
	public ResponseEntity<String> deleteplayer(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ResponseEntity.ok(playerService.deletePlayer(firstName, lastName));
	}
}
