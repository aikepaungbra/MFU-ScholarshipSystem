package com.example.mvc.Entity;

import java.time.LocalDate;
import java.util.List;

import com.example.mvc.AdminEntity.Admin;
import com.example.mvc.AdminEntity.ScholarApplicants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;
    
  
    @OneToMany(mappedBy = "scholarInfo", cascade = CascadeType.ALL)
	private List<ScholarApplicants> scholarApplicants;
    
}
