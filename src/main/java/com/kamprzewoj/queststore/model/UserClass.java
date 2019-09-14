package com.kamprzewoj.queststore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonProperty;
//@JsonProperty("name")


@Data
@Entity(name = "user_class")
public class UserClass {

//	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String photoUrl;

	public UserClass(String name, String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public UserClass() {}
}
