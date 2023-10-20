package com.basketballapp.teamservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.teamservice.config.ServiceConfig;
import com.basketballapp.teamservice.model.Team;
import com.basketballapp.teamservice.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	MessageSource messages;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	ServiceConfig config;

	public Team getTeam(int year, int grade) {
		Team team = teamRepository.findByYearAndGrade(year, grade);
		if (null == team) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("team.search.error.message", null, null), year, grade));
		}
		return team;
	}

	public Team createTeam(Team team) {
		teamRepository.save(team);

		return team;
	}

	public Team updateTeam(Team team) {
		this.deleteTeam(team.getYear(), team.getGrade());
		teamRepository.save(team);

		return team;
	}

	public String deleteTeam(int year, int grade) {
		Team team = teamRepository.findByYearAndGrade(year, grade);
		teamRepository.delete(team);
		return "team: " + year + " " + grade + " was deleted.";

	}
}
