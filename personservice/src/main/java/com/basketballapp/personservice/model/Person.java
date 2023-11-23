package com.basketballapp.personservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	@Column(unique = true)
	private String userName;

	@Column(unique = true)
	private String email;

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private String position;

}