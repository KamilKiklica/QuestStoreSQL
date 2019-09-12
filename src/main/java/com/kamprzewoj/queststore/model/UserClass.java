package com.kamprzewoj.queststore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "user_class")
public class UserClass {

	public UserClass(@JsonProperty("name") String name, @JsonProperty("photoUrl") String photoUrl) {
		this.name = name;
		this.photoUrl = photoUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private String photoUrl;
}
