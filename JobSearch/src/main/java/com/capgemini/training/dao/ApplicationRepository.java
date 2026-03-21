package com.capgemini.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.training.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
