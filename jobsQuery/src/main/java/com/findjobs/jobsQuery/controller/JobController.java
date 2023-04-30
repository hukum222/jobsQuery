package com.findjobs.jobsQuery.controller;

import com.findjobs.jobsQuery.model.Job;
import com.findjobs.jobsQuery.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@Valid @RequestBody Job job, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Job savedJob = jobService.save(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @Valid @RequestBody Job job, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Job existingJob = jobService.findById(id);
        if (existingJob == null) {
            return ResponseEntity.notFound().build();
        }
        job.setId(id);
        Job updatedJob = jobService.save(job);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        jobService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

