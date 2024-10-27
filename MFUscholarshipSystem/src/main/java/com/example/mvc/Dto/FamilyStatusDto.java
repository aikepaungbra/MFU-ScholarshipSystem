package com.example.mvc.Dto;

import com.example.mvc.Entity.FamilyStatus;

import lombok.Data;

@Data
public class FamilyStatusDto {


	private FamilyStatus.FamilyStatusOption familyStatusOption;

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
