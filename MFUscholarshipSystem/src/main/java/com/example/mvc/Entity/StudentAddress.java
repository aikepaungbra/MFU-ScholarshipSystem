package com.example.mvc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class StudentAddress {
	
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
	
	@Id
	private Long student_id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private StudentBasicInfo studentBasicInfo;

}
