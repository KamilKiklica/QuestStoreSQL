package QuestStore.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@SequenceGenerator(name="user_generator", sequenceName = "user_id_seq", allocationSize=5000)
	private Integer id;

	private String firstName;
	private String lastName;
	private String email;
	private String nickName;
	private String password;
	private String photoURL;
	private int accessRights;
	private int userLevel;
	Date dateStamp;

	public User() {
	}

	public User(Integer id, String firstName, String lastName, String email, String nickName, String password, String photoURL, int accessRights, int userLevel, Date dateStamp) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.photoURL = photoURL;
		this.accessRights = accessRights;
		this.userLevel = userLevel;
		this.dateStamp = dateStamp;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User users = (User) o;

		if (accessRights != users.accessRights) return false;
		if (userLevel != users.userLevel) return false;
		if (id != null ? !id.equals(users.id) : users.id != null) return false;
		if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
		if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
		if (email != null ? !email.equals(users.email) : users.email != null) return false;
		if (nickName != null ? !nickName.equals(users.nickName) : users.nickName != null) return false;
		if (password != null ? !password.equals(users.password) : users.password != null) return false;
		if (photoURL != null ? !photoURL.equals(users.photoURL) : users.photoURL != null) return false;
		return dateStamp != null ? dateStamp.equals(users.dateStamp) : users.dateStamp == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (photoURL != null ? photoURL.hashCode() : 0);
		result = 31 * result + accessRights;
		result = 31 * result + userLevel;
		result = 31 * result + (dateStamp != null ? dateStamp.hashCode() : 0);
		return result;
	}
}
