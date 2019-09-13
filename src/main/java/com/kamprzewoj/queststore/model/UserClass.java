package com.kamprzewoj.queststore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "user_class")
public class UserClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String photoUrl;

	public UserClass(@JsonProperty("name") String name, @JsonProperty("photoUrl") String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	public UserClass() {}
}
