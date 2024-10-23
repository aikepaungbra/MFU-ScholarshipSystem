package com.example.mvc.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ScholarInfo {

	
	private int scholar_id;
    private String scholar_name;
    private int fund_amount;
    private int given_number_of_student;
    private String sponsor;
    private LocalDate scholar_start_date;
    private LocalDate scholar_end_date;
    
}
