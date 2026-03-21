package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.entity.Job;
import com.capgemini.training.services.JobService;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private JobService jobService;

    // POST Job
    @PostMapping("/postJob")
    public Job postJob(@RequestParam Long employerId,
                       @RequestBody Job job) {

        return jobService.postJob(employerId, job);
    }
}