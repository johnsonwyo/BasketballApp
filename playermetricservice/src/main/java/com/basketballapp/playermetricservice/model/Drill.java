package com.basketballapp.playermetricservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Drill {

    @Id
    @GeneratedValue
    private int drillId;

    private String drillName;

    private int made;

    private int attempted;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @JsonBackReference
    private Player player;

}
