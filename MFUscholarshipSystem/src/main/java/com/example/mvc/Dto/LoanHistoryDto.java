package com.example.mvc.Dto;

import java.time.LocalDate;

import com.example.mvc.Dto.FamilyStatusDto.FamilyStatusOption;

import lombok.Data;


@Data
public class LoanHistoryDto {
	
	private LocalDate loanYearStart;
	private LocalDate loanYearEnd;
	private int loanAmount;

}
