package com.capgemini.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.EmployerRepository;
import com.capgemini.training.entity.Employer;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    // Create Employer
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    // Get All Employers
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    // Get Employer by ID
    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
    }

    // Delete Employer
    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
}