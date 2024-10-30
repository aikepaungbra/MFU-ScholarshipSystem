package com.example.mvc.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.AdminEntity.Admin;
import com.example.mvc.AdminEntity.ScholarApplicants;
import com.example.mvc.Entity.ScholarInfo;
import com.example.mvc.adminRepository.AdminRepo;
import com.example.mvc.adminRepository.ScholarApplicantsRepo;
import com.example.mvc.repository.ScholarInfoRepo;

@Service
public class AdminService {

	@Autowired
	private ScholarInfoRepo scholarInfoRepo;

	@Autowired
	private ScholarApplicantsRepo scholarApplicantsRepo;

	@Autowired
	private AdminRepo adminRepository;

	public boolean login(String email, String password) {
		Optional<Admin> adminOptional = adminRepository.findByAdminEmailIgnoreCase(email);

		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			System.out.println("Admin found: " + admin);
			return admin.getAdminPassword().equals(password);
		}

		System.out.println("Admin not found for email: " + email);
		return false;
	}

	public ScholarApplicants updateApplicantStatus(int applicant_Id, ScholarApplicants.ApplicationStatus status) {
		Optional<ScholarApplicants> applicantOptional = scholarApplicantsRepo.findById(applicant_Id);
		if (applicantOptional.isPresent()) {
			ScholarApplicants applicant = applicantOptional.get();
			applicant.setStatus(status);
			return scholarApplicantsRepo.save(applicant);
		}
		return null;
	}

	public ScholarInfo createNewScholarship(ScholarInfo scholarInfo) {
		return scholarInfoRepo.save(scholarInfo);
	}

	public boolean deleteScholarship(int scholarId) {

		Optional<ScholarInfo> scholarshipOptional = scholarInfoRepo.findById(scholarId);

		if (scholarshipOptional.isPresent()) {
			ScholarInfo scholarInfo = scholarshipOptional.get();
			LocalDate currentDate = LocalDate.now();

			if (scholarInfo.getScholar_end_date().isBefore(currentDate)) {
				scholarInfoRepo.delete(scholarInfo);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
