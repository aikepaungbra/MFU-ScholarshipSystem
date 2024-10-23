package com.example.mvc.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LastInfoDto {
	
	private Long student_id;
//	private byte[] advisorRecommendationLetter;
//	private byte[] familyIncomeCertifiacation;
//	private byte[] familyStatusCertification;
//	private byte[] nonParentalGuardianshipCertification;
	private String advisorRecommendationLetter;
	private String familyIncomeCertifiacation;//familyIncomeCertification
	private String familyStatusCertification;
	private String nonParentalGuardianshipCertification;
	private String signature;
	private LocalDate scholarship_date;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMontylyDebt;

}
