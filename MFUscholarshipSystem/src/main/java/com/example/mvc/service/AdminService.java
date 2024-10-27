package com.example.mvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.AdminEntity.ScholarApplicants;
import com.example.mvc.adminRepository.ScholarApplicantsRepo;
import com.example.mvc.repository.ScholarInfoRepo;

@Service
public class AdminService {

	@Autowired
	private ScholarInfoRepo scholarInfoRepo;

	@Autowired
	private ScholarApplicantsRepo scholarApplicantsRepo;
	
	public ScholarApplicants updateApplicantStatus(int applicant_Id, ScholarApplicants.ApplicationStatus status) {
        Optional<ScholarApplicants> applicantOptional = scholarApplicantsRepo.findById(applicant_Id);
        if (applicantOptional.isPresent()) {
            ScholarApplicants applicant = applicantOptional.get();
            applicant.setStatus(status);
            return scholarApplicantsRepo.save(applicant);
        }
        return null;
    }

}
