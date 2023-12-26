package com.sid.TaskManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAssignment;
    
    @ManyToOne(optional = false)
    private Task task;
}
