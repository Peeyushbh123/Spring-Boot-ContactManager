package com.smart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;

	private String name;

	private String secondname;

	private String work;

	@Column(unique=true)
	private String email;

	private String phone;

	private String image;

	@Column(length=50000)
	private String description;
	
	@ManyToOne()
	private User user;
	
	public int getcId() {

		return cId;
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public String getSecondname() {

		return secondname;
	}
	public void setSecondname(String secondname) {

		this.secondname = secondname;
	}
	public String getWork() {

		return work;
	}
	public void setWork(String work) {

		this.work = work;
	}
	public String getEmail() {

		return email;
	}
	public void setEmail(String email) {

		this.email = email;
	}
	public String getPhone() {

		return phone;
	}
	public void setPhone(String phone) {

		this.phone = phone;
	}
	public String getImage() {

		return image;
	}
	public void setImage(String image) {

		this.image = image;
	}
	public String getDescription() {

		return description;
	}
	public void setDescription(String description) {

		this.description = description;
	}
	public User getUsr() {

		return user;
	}
	public void setUsr(User user) {

		this.user = user;
	}
	
}
