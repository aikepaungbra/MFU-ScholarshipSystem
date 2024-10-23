package com.example.mvc.Dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ScholarshipHistoryDto {
	
	
	private Long student_id;

    private boolean scholarBefore;
    private String scholarName;
    private int recieveYear;
    private int scholarAmount;

    private LocalDate loanYearStart;
    private LocalDate loanYearEnd;
    private int loanAmount;

    
    private String howYouSpendEssay;

}
