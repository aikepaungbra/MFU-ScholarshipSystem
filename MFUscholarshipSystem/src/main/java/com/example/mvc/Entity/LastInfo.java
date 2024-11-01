package com.example.mvc.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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


	@Lob
	private String advisorRecommendationLetter;

	@Lob
	private String familyIncomeCertification;

	@Lob
	private String familyStatusCertification;

	@Lob
	private String nonParentalGuardianshipCertification;

//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String advisorRecommendationLetter;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String familyIncomeCertifiacation;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String familyStatusCertification;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String nonParentalGuardianshipCertification;
	
	private String signature;
	private LocalDate scholarship_date;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMonthlyDebt;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String mfuScholarshipEssay;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String howYouSpendEssay;
	
    

}
