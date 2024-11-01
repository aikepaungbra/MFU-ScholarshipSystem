package com.example.mvc.Dto;

import com.example.mvc.Entity.FamilyStatus;

import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FamilyStatusDto {


	private FamilyStatus.FamilyStatusOption familyStatusOption;

	private String additionalDetails;


	@Lob
	private String housePhoto1;

	@Lob
	private MultipartFile housePhoto1File;


	@Lob
	private String housePhoto2;

	@Lob
	private MultipartFile housePhoto2File;


	@Lob
	private String housePhoto3;

	@Lob
	private MultipartFile housePhoto3File;


	@Lob
	private String housePhoto4;

	@Lob
	private MultipartFile housePhoto4File;


	public enum FamilyStatusOption {
		marriedAndLiveToghther, marriedAndLiveSeparate, divorcedOrSeparete, fatherPassedAway, motherPassedAway,
		bothParentDoNotSupport, others
	}

}
