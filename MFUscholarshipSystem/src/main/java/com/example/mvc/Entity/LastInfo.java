package com.example.mvc.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class LastInfo {
	
	@Id
	private Long student_id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private StudentBasicInfo studentBasicInfo;
	
	private String advisorRecommendationLetter;
	private String familyIncomeCertifiacation;
	private String familyStatusCertification;
	private String nonParentalGuardianshipCertification;
	
	private String signature;
	private LocalDate scholarship_date;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMontylyDebt;
    
    @Lob
    private String mfuScholarshipEssay;
	
    
//	private byte[] advisorRecommendationLetter;
//	private byte[] familyIncomeCertifiacation;
//	private byte[] familyStatusCertification;
//	private byte[] nonParentalGuardianshipCertification;
	

}
