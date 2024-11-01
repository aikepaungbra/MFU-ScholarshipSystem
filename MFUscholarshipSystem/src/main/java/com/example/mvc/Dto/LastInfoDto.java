package com.example.mvc.Dto;

import java.time.LocalDate;

import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class LastInfoDto {

	@Lob
	private MultipartFile advisorRecommendationLetterFile;
	@Lob
	private MultipartFile familyIncomeCertificationFile;
	@Lob
	private MultipartFile familyStatusCertificationFile;
	@Lob
	private MultipartFile nonParentalGuardianshipCertificationFile;

	@Lob
	private String advisorRecommendationLetter;
	@Lob
	private String familyIncomeCertification;
	@Lob
	private String familyStatusCertification;
	@Lob
	private String nonParentalGuardianshipCertification;

//	private byte[] advisorRecommendationLetter;
//	private byte[] familyIncomeCertification;
//	private byte[] familyStatusCertification;
//	private byte[] nonParentalGuardianshipCertification;
//	private String advisorRecommendationLetter;
//	private String familyIncomeCertification;//familyIncomeCertification
//	private String familyStatusCertification;
//	private String nonParentalGuardianshipCertification;
//
	private String signature;
	private LocalDate scholarship_date;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMonthlyDebt;
    
    private String mfuScholarshipEssay;
    private String howYouSpendEssay;

}
