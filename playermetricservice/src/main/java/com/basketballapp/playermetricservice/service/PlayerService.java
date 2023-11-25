package com.basketballapp.playermetricservice.service;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.playermetricservice.config.ServiceConfig;
import com.basketballapp.playermetricservice.model.Player;
import com.basketballapp.playermetricservice.repository.PlayerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PlayerService {

	@Autowired
	MessageSource messages;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	ServiceConfig config;

	@CircuitBreaker(name = "playerService", fallbackMethod = "getDefaultPlayer")
	public Player getPlayer(String firstName, String lastName) {
		Player player = playerRepository.findByName(firstName, lastName);
		if (null == player) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("player.search.error.message", null, null), firstName, lastName));
		}
		return player;
	}

	@CircuitBreaker(name = "playerServiceDelay")
	public Player getPlayerDelay(String firstName, String lastName) throws TimeoutException {
		randomlyRunLong();
		Player player = playerRepository.findByName(firstName, lastName);
		if (null == player) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("player.search.error.message", null, null), firstName, lastName));
		}
		return player;
	}

	@CircuitBreaker(name = "playerServiceDelayFallback", fallbackMethod = "getDefaultPlayer")
	public Player getPlayerDelayFallback(String firstName, String lastName) throws TimeoutException {
		randomlyRunLong();
		Player player = playerRepository.findByName(firstName, lastName);
		if (null == player) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("player.search.error.message", null, null), firstName, lastName));
		}
		return player;
	}

	@SuppressWarnings("unused")
	private Player getDefaultPlayer(Throwable t) {
		Player player = new Player();
		player.setFirstName("Michael");
		player.setLastName("Jordan");
		player.setPosition("Shooting Gaurd");
		player.setComment("GOAT");

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

	private void randomlyRunLong() throws TimeoutException {
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum == 3)
			sleep();
	}

	private void sleep() throws TimeoutException {
		try {
			System.out.println("Sleep");
			Thread.sleep(5000);
			throw new java.util.concurrent.TimeoutException();
		} catch (InterruptedException e) {
		}
	}
}
