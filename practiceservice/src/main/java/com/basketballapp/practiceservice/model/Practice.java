package com.basketballapp.practiceservice.model;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "date", "grade" }) })
public class Practice {

	@Id
	@GeneratedValue
	private int practiceId;

	private String date;

	private int grade;

	private String comment;

	@OneToMany(mappedBy = "practice")
	@JsonManagedReference
	private Set<Event> events;

}