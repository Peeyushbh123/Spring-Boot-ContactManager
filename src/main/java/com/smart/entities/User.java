package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@Column(unique=true)
	private String email;
	private String pass;
	private String role;
	private boolean enabled;
	private String imageUrl;
	@Column(length=10000)
	private String about;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "user")
	private List<Contact> Contacts =new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {

		this.id = id;
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {

		this.role = role;
	}
	public boolean isEnabled() {

		return enabled;
	}
	public void setEnabled(boolean enabled) {

		this.enabled = enabled;
	}
	public String getImageUrl() {

		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {

		this.imageUrl = imageUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {

		this.about = about;
	}
	public List<Contact> getContacts() {

		return Contacts;
	}
	public void setContacts(List<Contact> Contacts) {

		this.Contacts = Contacts;
	}
	
}
