package com.capgemini.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Application(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	 @ManyToOne
	 @JoinColumn(name = "job_id")
	 private Job job;

	 @ManyToOne
	 @JoinColumn(name = "job_seeker_id")
	 private JobSeeker jobSeeker;
	
	 public Application() {
		 
	 }

	 public Job getJob() {
		 return job;
	 }

	 public void setJob(Job job) {
		 this.job = job;
	 }

	 public JobSeeker getJobSeeker() {
		 return jobSeeker;
	 }

	 public void setJobSeeker(JobSeeker jobSeeker) {
		 this.jobSeeker = jobSeeker;
	 }
	 
	 
}
