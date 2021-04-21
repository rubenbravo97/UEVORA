package org.thefarm.tweb.jpa;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Long id;
	private String userName;
	private String password;
	private String role;

	@OneToMany(mappedBy = "user")
	private List<Orders> orders;

	protected User() {}

	public User(String UserName, String password, String role) {

		this.userName = UserName;
		this.password = password;
		this.role = role;


	}

	@Override
	public String toString() {
		return String.format(
				"User[id=%d, Username='%s', password='%s', role='%s']",
				id, userName, password, role);
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	
}
