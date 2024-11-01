package com.example.mvc.controller;

import java.util.List;

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
		scholarshipFormService.saveScholarshipForm(scholarshipFormDto);
		model.addAttribute("message", "Scholarship form submitted successfully!");
		return "formSuccess";
	}

//	@GetMapping("/form/{id}")
//	public String getFormById(@PathVariable("id") Long studentId, Model model) {
//		ScholarshipFormDto scholarshipFormDto = scholarshipFormService.getScholarshipFormById(studentId);
//		model.addAttribute("scholarshipFormDto", scholarshipFormDto);
//		return "scholarshipForm";
//	}

}
