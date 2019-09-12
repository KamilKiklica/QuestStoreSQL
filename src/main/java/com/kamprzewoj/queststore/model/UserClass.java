package com.kamprzewoj.queststore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "userClass")
public class UserClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;
	@NotNull
	private String photoURL;
}


//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(
//		value = {"name", "value"},
//		allowGetters = true
//)
//public abstract class Class {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private long id;
//
//	private String name;
//	private String value;
//
//	public Class() {
//	} //todo Ask mentor Why empty constructor ? Java doesn't make them by self ?
//
//	public Class(String name, String value) {
//		this.name = name;
//		this.value = value;
//	}
//}

//public abstract class AuditModel implements Serializable {
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "created_at", nullable = false, updatable = false)
//	@CreatedDate
//	private Date createdAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "updated_at", nullable = false)
//	@LastModifiedDate
//	private Date updatedAt;