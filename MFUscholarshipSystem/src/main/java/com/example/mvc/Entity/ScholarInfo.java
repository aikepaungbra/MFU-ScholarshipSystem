package com.example.mvc.Entity;

import java.time.LocalDate;
import java.util.List;

import com.example.mvc.AdminEntity.Admin;
import com.example.mvc.AdminEntity.ScholarApplicants;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ScholarInfo {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scholar_id;

    private String scholar_name;
    private int fund_amount;
    private int given_number_of_student;
    private String sponsor;
    private LocalDate scholar_start_date;
    private LocalDate scholar_end_date;
    
    private boolean publish;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
    
  
    @OneToMany(mappedBy = "scholarInfo", cascade = CascadeType.ALL)
	private List<ScholarApplicants> scholarApplicants;
    
}
