package com.example.mvc.Dto;

import java.time.LocalDate;
import java.util.List;

import com.example.mvc.Entity.StudentBasicInfo;

import lombok.Data;

@Data
public class StudentBasicInfoDTO {

	private Long student_id;
	
	private StudentBasicInfo.Title title;

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
	
	private FamilyStatusDto familyStatusDto;
	
	private FatherInfoDto fatherInfoDto;
	
	private GurdianInfoDto gurdianInfoDto;
	
	private List<LoanHistoryDto> loanHistoryDtos;
	
	private MotherInfoDto motherInfoDto;
	
	private StudentAddressDto studentAddressDto;
	
	private LastInfoDto lastInfoDto;

	private List<SiblingInfoDto> siblingInfoDtos;

	private List<ScholarshipHistoryDto> scholarshipHistoryDtos;
	
	

	

}
