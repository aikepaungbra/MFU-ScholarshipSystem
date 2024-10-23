package com.example.mvc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class FamilyStatus {

	@Id
	private Long student_id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "student_id")
	private StudentBasicInfo studentBasicInfo;
	
	@Enumerated(EnumType.STRING)
	private FamilyStatusOption familyStatusOption;

	private String additionalDetails;

	private String housePhoto1;
	private String housePhoto2;
	private String housePhoto3;
	private String housePhoto4;
	
//	private byte[] housePhoto1;
//	private byte[] housePhoto2;
//	private byte[] housePhoto3;
//	private byte[] housePhoto4;
	
	public enum FamilyStatusOption {
		marriedAndLiveToghther, marriedAndLiveSeparate, divorcedOrSeparete, fatherPassedAway, motherPassedAway,
		bothParentDoNotSupport, others,
	}

}
