package com.findjobs.jobsQuery.model;

public enum JobType {
    IT("Information Technology"),
    HR("Human Resources"),
    SALES("Sales"),
    MARKETING("Marketing"),
    OTHER("Other");

    private final String label;

    private JobType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

