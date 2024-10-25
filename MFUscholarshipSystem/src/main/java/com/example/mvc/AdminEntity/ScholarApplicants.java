package com.example.mvc.AdminEntity;

import com.example.mvc.Entity.ScholarInfo;
import com.example.mvc.Entity.StudentBasicInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "ScholarApplicants", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "scholar_id"})})
public class ScholarApplicants {
	

    @Id
    private int history_id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentBasicInfo basicInfo;
    
    @ManyToOne
    @JoinColumn(name = "scholar_id", nullable = false)
    private ScholarInfo scholarInfo;
    
    private String status;
    
    
}
