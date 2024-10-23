package com.example.mvc.Entity;

import java.time.LocalDate;
import java.util.List;

import com.example.mvc.helper.SiblingInfoId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@IdClass(SiblingInfoId.class) 
public class SiblingInfo {
	
	@Id
    private Long student_id;
	
	@Id
    private int sibling_order; 

    private String sibling_Name;
    private LocalDate sibling_birthday;
    private int sibling_age;
    private String sibling_occupation;
    private String sibling_education;
    private int sibling_monthlyIncome;
    
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)  // Foreign key relationship to StudentBasicInfo
    private StudentBasicInfo basicInfo;
    

}
