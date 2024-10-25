package com.example.mvc.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LoanHistory {

	@Id
	private Long student_id;

	private LocalDate loanYearStart;
	private LocalDate loanYearEnd;
	private int loanAmount;

	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private StudentBasicInfo basicInfo;

}
