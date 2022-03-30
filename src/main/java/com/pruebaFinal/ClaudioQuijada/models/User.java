package com.pruebaFinal.ClaudioQuijada.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="user_id", nullable = false, unique= true)
	private Long id;
	
	@Size( min=3, message="UseerName must be present")
	private String username;
	
	@Size( min=5, message="Email must be greater than 5")
	private String email;
	@Size( min=3, message="Password must be greater than 8 characters")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	
	// Relaciones entre clases
	
	//1:N Show
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	private List<Show> userShows;
	
	//1:N Rating
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	//N:N  un usuario puede tener muchos roles como asi los roles pueden tener muchos usuarios
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;

	
	
	public User() {}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Show> getUserShows() {
		return userShows;
	}

	public void setUserShows(List<Show> userShows) {
		this.userShows = userShows;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
