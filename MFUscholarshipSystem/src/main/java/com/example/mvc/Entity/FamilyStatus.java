package com.example.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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

	@Lob
	private String housePhoto1;

	@Lob
	private String housePhoto2;

	@Lob
	private String housePhoto3;

	@Lob
	private String housePhoto4;


//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String housePhoto1;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String housePhoto2;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String housePhoto3;
//
//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String housePhoto4;
	
	
	public enum FamilyStatusOption {
		marriedAndLiveTogether, marriedAndLiveSeparate, divorcedOrSeparate, fatherPassedAway, motherPassedAway,
		bothParentDoNotSupport, others,
	}
	



}
