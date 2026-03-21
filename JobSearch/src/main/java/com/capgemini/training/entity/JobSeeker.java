package com.capgemini.training.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="jobSeeker")
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String skills;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public JobSeeker(Long id, String name, String email, String skills) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.skills = skills;
	}
	
	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
	private List<Application> applications;
	
	public JobSeeker() {
		
	}

}
