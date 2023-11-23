package com.basketballapp.playermetricservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.playermetricservice.config.ServiceConfig;
import com.basketballapp.playermetricservice.model.Drill;
import com.basketballapp.playermetricservice.repository.DrillRepository;
import com.basketballapp.playermetricservice.repository.PlayerRepository;

@Service
public class DrillService {

    @Autowired
    MessageSource messages;

    @Autowired
    private DrillRepository drillRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    ServiceConfig config;

    public Drill getDrill(int drillId) {
        Drill drill = drillRepository.findById(drillId).get();
        if (null == drill) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("drill.search.error.message", null, null), drillId));
        }
        return drill;
    }

    public Drill createDrill(Drill drill, String firstName, String lastName) {
        drill.setPlayer(playerRepository.findByName(firstName, lastName));
        drillRepository.save(drill);

        return drill;
    }

    public Drill updateDrill(Drill newDrill, String firstName, String lastName) {
        Drill drill = drillRepository.findById(newDrill.getDrillId()).get();
        this.deleteDrill(drill.getDrillId());
        this.createDrill(newDrill, firstName, lastName);
        return newDrill;
    }

    public String deleteDrill(int drillId) {
        drillRepository.delete(drillRepository.findById(drillId).get());
        return "Drill #: " + drillId + " was deleted.";

    }

}
