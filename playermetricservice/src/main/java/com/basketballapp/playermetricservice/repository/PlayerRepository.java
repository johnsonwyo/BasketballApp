package com.basketballapp.playermetricservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basketballapp.playermetricservice.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Query("SELECT p FROM Player p WHERE p.firstName = ?1 AND p.lastName = ?2")
    Player findByName(String firstName, String lastName);

}
