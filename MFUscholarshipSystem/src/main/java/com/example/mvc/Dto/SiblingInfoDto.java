package com.example.mvc.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SiblingInfoDto {
	

    private int sibling_order;
    private String sibling_Name;
    private LocalDate sibling_birthday;
    private int sibling_age;
    private String sibling_occupation;

    private String sibling_education;
    private int sibling_monthlyIncome;
    
    

}
