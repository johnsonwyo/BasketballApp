package com.basketballapp.teamservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.teamservice.config.ServiceConfig;
import com.basketballapp.teamservice.model.TeamDrill;
import com.basketballapp.teamservice.repository.TeamDrillRepository;
import com.basketballapp.teamservice.repository.TeamRepository;

@Service
public class TeamDrillService {

    @Autowired
    MessageSource messages;

    @Autowired
    private TeamDrillRepository drillRepository;

    @Autowired
    private TeamRepository playerRepository;

    @Autowired
    ServiceConfig config;

    public TeamDrill getTeamDrill(int teamDrillId) {
        TeamDrill drill = drillRepository.findById(teamDrillId).get();
        if (null == drill) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("drill.search.error.message", null, null), teamDrillId));
        }
        return drill;
    }

    public TeamDrill createTeamDrill(TeamDrill drill, int year, int grade) {
        drill.setTeam(playerRepository.findByYearAndGrade(year, grade));
        drillRepository.save(drill);

        return drill;
    }

    public TeamDrill updateTeamDrill(TeamDrill newDrill, int year, int grade) {
        TeamDrill drill = drillRepository.findById(newDrill.getTeamDrillId()).get();
        this.deleteTeamDrill(drill.getTeamDrillId());
        this.createTeamDrill(newDrill, year, grade);
        return newDrill;
    }

    public String deleteTeamDrill(int teamDrillId) {
        drillRepository.delete(drillRepository.findById(teamDrillId).get());
        return "Drill #: " + teamDrillId + " was deleted.";

    }

}
