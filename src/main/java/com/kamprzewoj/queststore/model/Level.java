package com.kamprzewoj.queststore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "levels")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private Integer value;

	public Level(@JsonProperty("name") String name, @JsonProperty("value") Integer value) {
		this.name = name;
		this.value = value;
	}

	public Level() {}
}

//todo https://codeboje.de/spring-data-rest-tutorial/

//@Entity
//public class User {
//
//	@Id
//	@GeneratedValue
//	private Long id;
//
//	private String username;
//
//	private String firstname;
//
//	private String lastname;
//
//	todo @ManyToOne(cascade= {CascadeType.ALL})
//	@JoinColumn(name="address_id")
//	private Address homeAddress;
//
//	//getter and setter omitted
//}

//@Entity
//public class Address {
//
//	@Id
//	@GeneratedValue
//	private Long id;
//
//	private String street;
//
//	private String zipCode;
//
//	private String city;
//
//	private String country;
//
//	//getter and setter omitted
//}