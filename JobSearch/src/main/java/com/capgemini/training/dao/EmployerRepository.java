package com.capgemini.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>{

}
