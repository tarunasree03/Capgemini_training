package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.entity.Application;
import com.capgemini.training.services.ApplicationService;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public Application applyJob(@RequestParam Long jobId,
                               @RequestParam Long seekerId) {

        return applicationService.applyJob(jobId, seekerId);
    }
}