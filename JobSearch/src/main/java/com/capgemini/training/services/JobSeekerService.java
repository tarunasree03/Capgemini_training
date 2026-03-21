package com.capgemini.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.JobSeekerRepository;
import com.capgemini.training.entity.JobSeeker;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    // Create Profile
    public JobSeeker createProfile(JobSeeker seeker) {
        return jobSeekerRepository.save(seeker);
    }

    // Get All Seekers
    public List<JobSeeker> getAllSeekers() {
        return jobSeekerRepository.findAll();
    }

    // Get by ID
    public JobSeeker getSeekerById(Long id) {
        return jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));
    }

    // Update Profile
    public JobSeeker updateSeeker(Long id, JobSeeker updated) {
        JobSeeker seeker = getSeekerById(id);

        seeker.setName(updated.getName());
        seeker.setEmail(updated.getEmail());
        seeker.setSkills(updated.getSkills());

        return jobSeekerRepository.save(seeker);
    }

    // Delete
    public void deleteSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }
}
