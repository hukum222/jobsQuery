package com.findjobs.jobsQuery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 100, message = "Title should be between 5 and 100 characters")
    private String title;

    @NotNull
    @Size(min = 10, max = 1000, message = "Description should be between 10 and 1000 characters")
    private String description;

    @NotNull
    @Size(min = 2, max = 100, message = "Location should be between 2 and 100 characters")
    private String location;

    @NotNull
    @PositiveOrZero(message = "Salary should be a positive number")
    private Double salary;

    @NotNull
    @Size(min = 2, max = 100, message = "Company name should be between 2 and 100 characters")
    private String companyName;

    @NotNull
    @Size(min = 2, max = 100, message = "Employer name should be between 2 and 100 characters")
    private String employerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;

    public void setId(Long id) {
        this.id = id;
    }

    // getters and setters
}
