package com.basketballapp.practiceservice.model;

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
public class Event {

    @Id
    @GeneratedValue
    private int eventId;

    private String eventName;

    private int durationMinutes;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = false)
    @JsonBackReference
    private Practice practice;

}
