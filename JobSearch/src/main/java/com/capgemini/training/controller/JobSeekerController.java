package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.entity.JobSeeker;
import com.capgemini.training.services.JobSeekerService;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/register")
    public JobSeeker register(@RequestBody JobSeeker seeker) {
        return jobSeekerService.createProfile(seeker);
    }
}
