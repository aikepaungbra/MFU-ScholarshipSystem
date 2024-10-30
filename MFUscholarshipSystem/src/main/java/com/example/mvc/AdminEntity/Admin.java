package com.example.mvc.AdminEntity;

import java.util.List;
import com.example.mvc.Entity.ScholarInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Admin {
	
	@Id
    private Long admin_id;
	
	
	private String adminEmail;
	
	
    private String adminPassword;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<ScholarInfo> scholarships;

}
