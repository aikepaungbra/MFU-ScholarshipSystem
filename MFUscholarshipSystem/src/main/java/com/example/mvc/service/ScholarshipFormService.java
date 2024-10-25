package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Dto.LastInfoDto;
import com.example.mvc.Dto.ScholarshipHistoryDto;
import com.example.mvc.Dto.SiblingInfoDto;
import com.example.mvc.Dto.StudentBasicInfoDTO;
import com.example.mvc.Entity.LastInfo;
import com.example.mvc.Entity.ScholarshipHistory;
import com.example.mvc.Entity.SiblingInfo;
import com.example.mvc.Entity.StudentBasicInfo;
import com.example.mvc.helper.SiblingInfoId;
import com.example.mvc.repository.LastInfoRepo;
import com.example.mvc.repository.ScholarshipHistoryRepo;
import com.example.mvc.repository.SiblingInfoRepo;
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

	@Transactional
	public void saveScholarshipForm(StudentBasicInfoDTO studentBasicInfoDTO, LastInfoDto lastInfoDto,
			ScholarshipHistoryDto scholarshipHistoryDto, List<SiblingInfoDto> siblingInfoDtos) {

		// Retrieve or create StudentBasicInfo entity
	    StudentBasicInfo studentBasicInfo = studentBasicInfoRepository.findById(studentBasicInfoDTO.getStudent_id())
	            .orElseGet(() -> {
	                StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
	                newStudentBasicInfo.setStudent_id(studentBasicInfoDTO.getStudent_id());
	                newStudentBasicInfo.setStudent_name(studentBasicInfoDTO.getStudent_name());
	                // Set other fields from studentBasicInfoDTO...
	                return studentBasicInfoRepository.save(newStudentBasicInfo);
	            });

	    // Create and save LastInfo entity
	    LastInfo lastInfo = new LastInfo();
	    lastInfo.setStudentBasicInfo(studentBasicInfo); // Set the relationship
	    lastInfo.setAdvisorRecommendationLetter(lastInfoDto.getAdvisorRecommendationLetter());
	    lastInfo.setFamilyIncomeCertifiacation(lastInfoDto.getFamilyIncomeCertifiacation());
	    lastInfo.setFamilyStatusCertification(lastInfoDto.getFamilyStatusCertification());
	    lastInfo.setNonParentalGuardianshipCertification(lastInfoDto.getNonParentalGuardianshipCertification());
	    lastInfo.setSignature(lastInfoDto.getSignature());
	    lastInfo.setScholarship_date(lastInfoDto.getScholarship_date());
	    lastInfo.setTotalFamilyIncome(lastInfoDto.getTotalFamilyIncome());
	    lastInfo.setTotalFamilyExpensive(lastInfoDto.getTotalFamilyExpensive());
	    lastInfo.setTotalMontylyDebt(lastInfoDto.getTotalMontylyDebt());

	    lastInfoRepository.save(lastInfo);

	    // Create and save ScholarshipHistory entity
	    ScholarshipHistory scholarshipHistory = new ScholarshipHistory();
	    scholarshipHistory.setStudent_id(studentBasicInfo.getStudent_id()); // Set the student_id manually
	    scholarshipHistory.setBasicInfo(studentBasicInfo); // Set the relationship
	    scholarshipHistory.setScholarBefore(scholarshipHistoryDto.isScholarBefore());
	    scholarshipHistory.setScholarName(scholarshipHistoryDto.getScholarName());
	    scholarshipHistory.setRecieveYear(scholarshipHistoryDto.getRecieveYear());
	    scholarshipHistory.setScholarAmount(scholarshipHistoryDto.getScholarAmount());
//	    scholarshipHistory.setLoanYearStart(scholarshipHistoryDto.getLoanYearStart());
//	    scholarshipHistory.setLoanYearEnd(scholarshipHistoryDto.getLoanYearEnd());
//	    scholarshipHistory.setLoanAmount(scholarshipHistoryDto.getLoanAmount());
//	    scholarshipHistory.setHowYouSpendEssay(scholarshipHistoryDto.getHowYouSpendEssay());

	    scholarshipHistoryRepository.save(scholarshipHistory);

	    // Save SiblingInfo entries
	    for (SiblingInfoDto siblingInfoDto : siblingInfoDtos) {
	        SiblingInfo siblingInfo = new SiblingInfo();
	        siblingInfo.setBasicInfo(studentBasicInfo); // Set the relationship
	        siblingInfo.setStudent_id(studentBasicInfo.getStudent_id()); // Make sure to set the student_id
	        siblingInfo.setSibling_order(siblingInfoDto.getSibling_order());
	        siblingInfo.setSibling_Name(siblingInfoDto.getSibling_Name());
	        siblingInfo.setSibling_birthday(siblingInfoDto.getSibling_birthday());
	        siblingInfo.setSibling_age(siblingInfoDto.getSibling_age());
	        siblingInfo.setSibling_occupation(siblingInfoDto.getSibling_occupation());
	        siblingInfo.setSibling_education(siblingInfoDto.getSibling_education());
	        siblingInfo.setSibling_monthlyIncome(siblingInfoDto.getSibling_monthlyIncome());

	        siblingInfoRepository.save(siblingInfo);
	    }
	}

}
