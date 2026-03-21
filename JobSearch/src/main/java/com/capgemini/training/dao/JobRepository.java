package com.capgemini.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
