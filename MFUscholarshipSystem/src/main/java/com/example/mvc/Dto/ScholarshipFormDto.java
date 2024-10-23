package com.example.mvc.Dto;

import java.util.List;

import lombok.Data;

@Data
public class ScholarshipFormDto {

	private StudentBasicInfoDTO studentBasicInfoDTO;
	private LastInfoDto lastInfoDto;
	private ScholarshipHistoryDto scholarshipHistoryDto;
	private List<SiblingInfoDto> siblingInfoDtos;

}
