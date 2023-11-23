package com.basketballapp.playermetricservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.playermetricservice.config.ServiceConfig;
import com.basketballapp.playermetricservice.model.Player;
import com.basketballapp.playermetricservice.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	MessageSource messages;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	ServiceConfig config;

	public Player getPlayer(String firstName, String lastName) {
		Player player = playerRepository.findByName(firstName, lastName);
		if (null == player) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("player.search.error.message", null, null), firstName, lastName));
		}
		return player;
	}

	public Player createPlayer(Player player) {
		playerRepository.save(player);

		return player;
	}

	public Player updatePlayer(Player player) {
		this.deletePlayer(player.getFirstName(), player.getLastName());
		playerRepository.save(player);

		return player;
	}

	public String deletePlayer(String firstName, String lastName) {
		Player player = playerRepository.findByName(firstName, lastName);
		playerRepository.delete(player);
		return "Player: " + firstName + " " + lastName + " was deleted.";

	}
}
