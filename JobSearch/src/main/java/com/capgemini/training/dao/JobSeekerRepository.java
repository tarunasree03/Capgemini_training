package com.capgemini.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
