package com.findjobs.jobsQuery.repo;

import com.findjobs.jobsQuery.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job, Long> {
}

