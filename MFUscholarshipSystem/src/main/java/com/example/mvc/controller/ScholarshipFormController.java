package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

@RestController
@RequestMapping("/scholarship-form")
public class ScholarshipFormController {

	@Autowired
	private ScholarshipFormService scholarshipFormService;

//	@GetMapping("/new")
//	public String displayScholarshipForm(Model model) {
//		StudentBasicInfoDTO studentBasicInfoDTO = new StudentBasicInfoDTO();
//
//		// Initialize the sub-DTOs and add them to the StudentBasicInfoDTO object
//		studentBasicInfoDTO.setLastInfoDto(new LastInfoDto());
//
//		// Create a list with one ScholarshipHistoryDto and set it
//		List<ScholarshipHistoryDto> scholarshipHistoryList = List.of(new ScholarshipHistoryDto());
//		studentBasicInfoDTO.setScholarshipHistoryDtos(scholarshipHistoryList);
//
//		// Add a sibling placeholder
//		studentBasicInfoDTO.setSiblingInfoDtos(List.of(new SiblingInfoDto()));
//
//		// Add the StudentBasicInfoDTO object to the model
//		model.addAttribute("studentBasicInfoDTO", studentBasicInfoDTO);
//
//		return "scholarshipForm";
//	}
//
//	// Method to handle form submission
//	@PostMapping("/submit")
//	public String submitScholarshipForm(@ModelAttribute StudentBasicInfoDTO studentBasicInfoDTO,
//			@ModelAttribute LastInfoDto lastInfoDto, @ModelAttribute ScholarshipHistoryDto scholarshipHistoryDto,
//			@ModelAttribute List<SiblingInfoDto> siblingInfoDtos, Model model) {
//
//		try {
//			// Call the service to save the form data
//			scholarshipFormService.saveScholarshipForm(studentBasicInfoDTO, lastInfoDto, scholarshipHistoryDto,
//					siblingInfoDtos);
//			model.addAttribute("message", "Form submitted successfully!");
//			return "formSuccess"; // return a success page after submission
//		} catch (Exception e) {
//			// In case of errors, return the form page with an error message
//			model.addAttribute("error", "An error occurred while submitting the form: " + e.getMessage());
//			return "scholarshipForm"; // return back to the form page on error
//		}
//	}

//	@PostMapping("/submit")
//    public String submitScholarshipForm(@RequestBody ScholarshipFormDto scholarshipFormDto) {
//        // Extract the individual DTOs from the combined DTO
//        scholarshipFormService.saveScholarshipForm(
//            scholarshipFormDto.getStudentBasicInfoDTO(),
//            scholarshipFormDto.getLastInfoDto(),
//            scholarshipFormDto.getScholarshipHistoryDto(),
//            scholarshipFormDto.getSiblingInfoDtos()
//        );
//        return "Form submitted successfully!";}

}
