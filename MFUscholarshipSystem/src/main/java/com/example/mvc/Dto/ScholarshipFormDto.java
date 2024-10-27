package com.example.mvc.Dto;

import java.util.List;

import lombok.Data;

@Data
public class ScholarshipFormDto {
	
	private int scholar_id;

	private StudentBasicInfoDTO studentBasicInfoDTO;
	
	private LastInfoDto lastInfoDto;
	
	private List<SiblingInfoDto> siblingInfoDtos;

	private FamilyStatusDto familyStatusDto;

	private FatherInfoDto fatherInfoDto;

	private GurdianInfoDto gurdianInfoDto;

	private List<LoanHistoryDto> loanHistoryDtos;

	private MotherInfoDto motherInfoDto;

	private StudentAddressDto studentAddressDto;

	private List<ScholarshipHistoryDto> scholarshipHistoryDtos;
}
