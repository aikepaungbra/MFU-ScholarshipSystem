package com.example.mvc.Entity;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity()
public class ScholarshipHistory {
	
	@Id
	private Long student_id;

    private boolean scholarBefore;
    private String scholarName;
    private int recieveYear;
    private int scholarAmount;

   
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentBasicInfo basicInfo;
    

}
