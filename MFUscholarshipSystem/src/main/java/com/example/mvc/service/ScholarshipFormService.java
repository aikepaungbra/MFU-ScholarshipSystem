package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Dto.FamilyStatusDto;
import com.example.mvc.Dto.FatherInfoDto;
import com.example.mvc.Dto.GurdianInfoDto;
import com.example.mvc.Dto.LastInfoDto;
import com.example.mvc.Dto.MotherInfoDto;
import com.example.mvc.Dto.ScholarshipFormDto;
import com.example.mvc.Dto.ScholarshipHistoryDto;
import com.example.mvc.Dto.SiblingInfoDto;
import com.example.mvc.Dto.StudentBasicInfoDTO;
import com.example.mvc.Entity.LastInfo;
import com.example.mvc.Entity.ScholarshipHistory;
import com.example.mvc.Entity.SiblingInfo;
import com.example.mvc.Entity.StudentBasicInfo;
import com.example.mvc.helper.SiblingInfoId;
import com.example.mvc.repository.FamilyStatusRepo;
import com.example.mvc.repository.FatherInfoRepo;
import com.example.mvc.repository.GurdianInfoRepo;
import com.example.mvc.repository.LastInfoRepo;
import com.example.mvc.repository.LoanHistoryRepo;
import com.example.mvc.repository.MotherInfoRepo;
import com.example.mvc.repository.ScholarInfoRepo;
import com.example.mvc.repository.ScholarshipHistoryRepo;
import com.example.mvc.repository.SiblingInfoRepo;
import com.example.mvc.repository.StudentAddressRepo;
import com.example.mvc.repository.StudentBasicInfoRepo;

import jakarta.transaction.Transactional;

@Service
public class ScholarshipFormService {

	@Autowired
	private StudentBasicInfoRepo studentBasicInfoRepository;

	@Autowired
	private LastInfoRepo lastInfoRepository;

	@Autowired
	private ScholarshipHistoryRepo scholarshipHistoryRepository;

	@Autowired
	private SiblingInfoRepo siblingInfoRepository;

	@Autowired
	private FamilyStatusRepo familyStatusRepo;

	@Autowired
	private FatherInfoRepo fatherInfoRepo;

	@Autowired
	private GurdianInfoRepo gurdianInfoRepo;

	@Autowired
	private LoanHistoryRepo loanHistoryRepo;

	@Autowired
	private MotherInfoRepo motherInfoRepo;

	@Autowired
	private StudentAddressRepo studentAddressRepo;

	@Autowired
	private ScholarInfoRepo scholarInfoRepo;

	@Transactional
	public void saveScholarshipForm(ScholarshipFormDto scholarshipFormDto) {

		StudentBasicInfo studentBasicInfo = studentBasicInfoRepository
				.findById(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_id()).orElseGet(() -> {
					StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
					newStudentBasicInfo.setStudent_id(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_id());
					newStudentBasicInfo.setStudent_name(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_name());
					
					return studentBasicInfoRepository.save(newStudentBasicInfo);
				});

	}

}
