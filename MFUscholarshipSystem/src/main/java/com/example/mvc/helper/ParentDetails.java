package com.example.mvc.helper;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class ParentDetails {

	private String city_town_village;
    private String houseNum;
    private String moo;
    private String road;
    private String subDistrict;
    private String district;
    private String province;
    private int postal_Code;
    private int home_phone_Number;
    
    private String name;
	private int age;
	private String occupation;
	private String postion;
	private int monthy_income;
	private int yearly_income;
	private String landOwned_rent_Rai;
    public int phone_Number;
    
    private String work_place;
    private String num;
    private String work_moo;
    private String work_road;
    private String work_subDistrict;
    private String work_district;
    private String work_province;
    private int work_postal_Code;
    private int work_phone_Number;
}
