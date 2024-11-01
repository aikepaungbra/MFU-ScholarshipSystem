package com.example.mvc.controller;

import java.util.List;

import com.example.mvc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.Dto.LastInfoDto;
import com.example.mvc.Dto.ScholarshipFormDto;
import com.example.mvc.Dto.ScholarshipHistoryDto;
import com.example.mvc.Dto.SiblingInfoDto;
import com.example.mvc.Dto.StudentBasicInfoDTO;
import com.example.mvc.service.ScholarshipFormService;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/scholarship-form")
public class ScholarshipFormController {

	@Autowired
	private ScholarshipFormService scholarshipFormService;

	@GetMapping("/form")
	public String getScholarshipForm(Model model) {
		model.addAttribute("scholarshipFormDto", new ScholarshipFormDto());
		return "scholarshipForm";
	}

	@PostMapping("/submit")
	public String saveScholarshipForm(@ModelAttribute("scholarshipFormDto") ScholarshipFormDto scholarshipFormDto,
			Model model) {

		MultipartFile studentPhotoFile = scholarshipFormDto.getStudentBasicInfoDTO().getStudentPhotoFile();
		scholarshipFormDto.getStudentBasicInfoDTO().setStudentPhoto(FileService.convertFileToBase64(studentPhotoFile));

		MultipartFile housePhoto1File = scholarshipFormDto.getFamilyStatusDto().getHousePhoto1File();
		scholarshipFormDto.getFamilyStatusDto().setHousePhoto1(FileService.convertFileToBase64(housePhoto1File));

		MultipartFile housePhoto2File = scholarshipFormDto.getFamilyStatusDto().getHousePhoto2File();
		scholarshipFormDto.getFamilyStatusDto().setHousePhoto2(FileService.convertFileToBase64(housePhoto2File));

		MultipartFile housePhoto3File = scholarshipFormDto.getFamilyStatusDto().getHousePhoto3File();
		scholarshipFormDto.getFamilyStatusDto().setHousePhoto3(FileService.convertFileToBase64(housePhoto3File));

		MultipartFile housePhoto4File = scholarshipFormDto.getFamilyStatusDto().getHousePhoto4File();
		scholarshipFormDto.getFamilyStatusDto().setHousePhoto4(FileService.convertFileToBase64(housePhoto4File));


		MultipartFile advisorRecommendationLetterFile = scholarshipFormDto.getLastInfoDto().getAdvisorRecommendationLetterFile();
		scholarshipFormDto.getLastInfoDto().setAdvisorRecommendationLetter(FileService.convertFileToBase64(advisorRecommendationLetterFile));

		MultipartFile familyIncomeCertificationFile = scholarshipFormDto.getLastInfoDto().getFamilyIncomeCertificationFile();
		scholarshipFormDto.getLastInfoDto().setFamilyIncomeCertification(FileService.convertFileToBase64(familyIncomeCertificationFile));

		MultipartFile familyStatusCertificationFile = scholarshipFormDto.getLastInfoDto().getFamilyStatusCertificationFile();
		scholarshipFormDto.getLastInfoDto().setFamilyStatusCertification(FileService.convertFileToBase64(familyStatusCertificationFile));

		MultipartFile nonParentalGuardianshipCertificationFile = scholarshipFormDto.getLastInfoDto().getNonParentalGuardianshipCertificationFile();
		scholarshipFormDto.getLastInfoDto().setNonParentalGuardianshipCertification(FileService.convertFileToBase64(nonParentalGuardianshipCertificationFile));


		scholarshipFormService.saveScholarshipForm(scholarshipFormDto);
		model.addAttribute("ScholarshipFormDto", scholarshipFormDto);
		return "formSuccess";
	}
//
//	@GetMapping("/form/{id}")
//	public String getFormById(@PathVariable("id") Long studentId, Model model) {
//		ScholarshipFormDto scholarshipFormDto = scholarshipFormService.getScholarshipFormById(studentId);
//		model.addAttribute("scholarshipFormDto", scholarshipFormDto);
//		return "scholarshipForm";
//	}

}
