package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="login")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String useroradmin;
	private String email;
	private String username;
	private String phonenumber;
	private String password;
	private String confirmpassword;
	public UserModel(){
		
	}
	public UserModel(String username, String email){
		this.username=username;
		this.email=email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public String getUseroradmin() {
		return useroradmin;
	}
	public void setUseroradmin(String useroradmin) {
		this.useroradmin = useroradmin;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfrmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
