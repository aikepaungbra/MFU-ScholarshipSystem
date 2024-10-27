package com.example.mvc.Dto;

import lombok.Data;

@Data
public class FamilyStatusDto {


	private FamilyStatusOption familyStatusOption;

	private String additionalDetails;

	private String housePhoto1;
	private String housePhoto2;
	private String housePhoto3;
	private String housePhoto4;

	public enum FamilyStatusOption {
		marriedAndLiveToghther, marriedAndLiveSeparate, divorcedOrSeparete, fatherPassedAway, motherPassedAway,
		bothParentDoNotSupport, others
	}

}
