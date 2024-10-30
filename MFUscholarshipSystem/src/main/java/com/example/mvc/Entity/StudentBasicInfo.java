package com.example.mvc.Entity;

import java.time.LocalDate;
import java.util.List;

import com.example.mvc.AdminEntity.ScholarApplicants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
public class StudentBasicInfo {

	@Id
	private Long student_id;
	
	@Enumerated(EnumType.STRING)
	private Title student_title; 
	
	public enum Title {
	    MR, MRS, MS
	}

	private String student_name;
	private LocalDate student_dateOfBirth;
	private int student_age;
	private String student_year;
	private String student_major;
	private String schoolOf;
	private double student_gpaX;
	private String student_phoneNumber;
	private String student_email;
	private String student_advisorName;
	
	@OneToMany(mappedBy = "basicInfo", cascade = CascadeType.ALL)
	private List<ScholarApplicants> scholarApplicants;
	
    @OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private LastInfo lastInfo;

	@OneToMany(mappedBy = "basicInfo")
	private List<SiblingInfo> siblings;
	
	@OneToMany(mappedBy = "basicInfo")
	private List<LoanHistory> loanHistories;
	
	@OneToMany(mappedBy = "basicInfo")
	private List<ScholarshipHistory> scholarshipHistories;
	
	@OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private FatherInfo fatherInfo;
	
	@OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private MotherInfo motherInfo;
	
	@OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private GurdianInfo gurdianInfo;
	
	@OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private StudentAddress studentAddress;
	
	@OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private FamilyStatus familyStatus;

}
