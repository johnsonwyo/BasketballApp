package com.basketballapp.teamservice.model;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "year", "grade" }) })
public class Team {

	@Id
	@GeneratedValue
	private int teamId;

	private int year;

	private int grade;

	private String finalRank;

	private String comment;

	@OneToMany(mappedBy = "team")
	@JsonManagedReference
	private Set<TeamDrill> teamDrills;

}