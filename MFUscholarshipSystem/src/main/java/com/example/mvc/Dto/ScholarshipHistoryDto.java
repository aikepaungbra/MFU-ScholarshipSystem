package com.example.mvc.Dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ScholarshipHistoryDto {
	
	
    private boolean scholarBefore;
    private String scholarName;
    private int recieveYear;
    private int scholarAmount;

   

}
