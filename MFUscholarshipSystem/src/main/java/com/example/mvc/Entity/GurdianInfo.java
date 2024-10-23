package com.example.mvc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class GurdianInfo {
	
	public String gurdian_name;
	private String gurdian_relationship;
    private int gurdian_monthlySupport;
    public String gurdian_occupation;
    public String gurdian_position;
    public int gurdian_monthlyIncome;
    public int gurdian_yearlyIncome;
    public String gurdian_landOwned_rent_Rai;
    public int gurdian_phoneNumber;
    
    private String work_place;
    private String num;
    private String work_moo;
    private String work_road;
    private String work_subDistrict;
    private String work_district;
    private String work_province;
    private int work_postal_Code;
    private int work_phone_Number;
    
    private String city_town_village;
    private String houseNum;
    private String moo;
    private String road;
    private String subDistrict;
    private String district;
    private String province;
    private int postal_Code;
    private int home_phone_Number;
    
    @Id
	private Long student_id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private StudentBasicInfo studentBasicInfo;
    

}
