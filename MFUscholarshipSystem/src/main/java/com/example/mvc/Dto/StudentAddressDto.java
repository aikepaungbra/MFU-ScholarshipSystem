package com.example.mvc.Dto;

import com.example.mvc.Dto.FamilyStatusDto.FamilyStatusOption;

import lombok.Data;

@Data
public class StudentAddressDto {
	
	private String permanent_city_town_village;
    private String permanent_houseNum;
    private String permanent_moo;
    private String permanent_road;
    private String permanent_subDistrict;
    private String permanent_district;
    private String permanent_province;
    private int permanent_postalCode;

    private String current_city_town_village;
	private String current_houseNum;
	private String current_moo;
	private String current_road;
	private String current_subDistrict;
	private String current_district;
	private String current_province;
	private int current_postalCode;
	

}
