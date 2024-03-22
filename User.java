package com.farming.models;

//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String contactinfo;
	private String email;
	private String password;
	private String role;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String contactinfo, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.contactinfo = contactinfo;
		this.email = email;
		this.password = password;
		this.role = role;
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



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getContactinfo() {
		return contactinfo;
	}



	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		
	}
	public Object getFarmerId() {
		// TODO Auto-generated method stub
		return null;
	}	
}
