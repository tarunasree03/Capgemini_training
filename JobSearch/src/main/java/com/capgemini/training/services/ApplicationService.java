package com.capgemini.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.ApplicationRepository;
import com.capgemini.training.dao.JobRepository;
import com.capgemini.training.dao.JobSeekerRepository;
import com.capgemini.training.entity.Application;
import com.capgemini.training.entity.Job;
import com.capgemini.training.entity.JobSeeker;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    // Apply for Job
    public Application applyJob(Long jobId, Long seekerId) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobSeeker seeker = jobSeekerRepository.findById(seekerId)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));

        Application app = new Application(null, "APPLIED");
        app.setJob(job);
        app.setJobSeeker(seeker);

        return applicationRepository.save(app);
    }

    // Get All Applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Delete Application
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
