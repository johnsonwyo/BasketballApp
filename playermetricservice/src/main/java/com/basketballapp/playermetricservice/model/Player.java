package com.basketballapp.playermetricservice.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "firstName", "lastName" }) })
public class Player {

	@Id
	@GeneratedValue
	private int playerId;

	private String firstName;

	private String lastName;

	private String position;

	private String comment;

	@OneToMany(mappedBy = "player")
	@JsonManagedReference
	private Set<Drill> drills;

}