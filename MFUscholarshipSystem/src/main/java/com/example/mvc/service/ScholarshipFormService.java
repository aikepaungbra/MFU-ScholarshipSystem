package com.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.AdminEntity.ScholarApplicants;
import com.example.mvc.Dto.FamilyStatusDto;
import com.example.mvc.Dto.FatherInfoDto;
import com.example.mvc.Dto.GurdianInfoDto;
import com.example.mvc.Dto.LastInfoDto;
import com.example.mvc.Dto.LoanHistoryDto;
import com.example.mvc.Dto.MotherInfoDto;
import com.example.mvc.Dto.ScholarshipFormDto;
import com.example.mvc.Dto.ScholarshipHistoryDto;
import com.example.mvc.Dto.SiblingInfoDto;
import com.example.mvc.Dto.StudentBasicInfoDTO;
import com.example.mvc.Entity.FamilyStatus;
import com.example.mvc.Entity.FatherInfo;
import com.example.mvc.Entity.GurdianInfo;
import com.example.mvc.Entity.LastInfo;
import com.example.mvc.Entity.LoanHistory;
import com.example.mvc.Entity.MotherInfo;
import com.example.mvc.Entity.ScholarInfo;
import com.example.mvc.Entity.ScholarshipHistory;
import com.example.mvc.Entity.SiblingInfo;
import com.example.mvc.Entity.StudentAddress;
import com.example.mvc.Entity.StudentBasicInfo;
import com.example.mvc.adminRepository.ScholarApplicantsRepo;
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
	
	private ScholarApplicantsRepo scholarApplicantsRepo;

	@Transactional
	public void saveScholarshipForm(ScholarshipFormDto scholarshipFormDto) {

		StudentBasicInfo studentBasicInfo = studentBasicInfoRepository
				.findById(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_id()).orElseGet(() -> {
					
					StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
					
					newStudentBasicInfo.setStudent_id(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_id());
					newStudentBasicInfo.setStudent_name(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_name());
					newStudentBasicInfo.setStudent_dateOfBirth(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_dateOfBirth());
					newStudentBasicInfo.setStudent_age(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_age());
					newStudentBasicInfo.setStudent_year(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_year());
					newStudentBasicInfo.setStudent_major(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_major());
					newStudentBasicInfo.setSchoolOf(scholarshipFormDto.getStudentBasicInfoDTO().getSchoolOf());
					newStudentBasicInfo.setStudent_gpaX(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_gpaX());
					newStudentBasicInfo.setStudent_phoneNumber(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_phoneNumber());
					newStudentBasicInfo.setStudent_email(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_email());
					newStudentBasicInfo.setStudent_advisorName(scholarshipFormDto.getStudentBasicInfoDTO().getStudent_advisorName());
					return studentBasicInfoRepository.save(newStudentBasicInfo);
				});
		
		ScholarInfo scholarInfo = scholarInfoRepo.findById(scholarshipFormDto.getScholar_id())
	            .orElseThrow(() -> new IllegalArgumentException("Scholarship not found with id: " + scholarshipFormDto.getScholar_id()));
		
		ScholarApplicants scholarApplicant = new ScholarApplicants();
	    scholarApplicant.setScholarInfo(scholarInfo); 
	    scholarApplicant.setBasicInfo(studentBasicInfo); 
	    scholarApplicant.setStatus(ScholarApplicants.ApplicationStatus.PENDING); 
	    scholarApplicantsRepo.save(scholarApplicant);
		
		
		LastInfo lastInfo = new LastInfo();
        lastInfo.setStudentBasicInfo(studentBasicInfo);
        lastInfo.setAdvisorRecommendationLetter(scholarshipFormDto.getLastInfoDto().getAdvisorRecommendationLetter());
        lastInfo.setFamilyIncomeCertifiacation(scholarshipFormDto.getLastInfoDto().getFamilyIncomeCertifiacation());
        lastInfo.setFamilyStatusCertification(scholarshipFormDto.getLastInfoDto().getFamilyStatusCertification());
        lastInfo.setNonParentalGuardianshipCertification(scholarshipFormDto.getLastInfoDto().getNonParentalGuardianshipCertification());
        lastInfo.setSignature(scholarshipFormDto.getLastInfoDto().getSignature());
        lastInfo.setScholarship_date(scholarshipFormDto.getLastInfoDto().getScholarship_date());
        lastInfo.setTotalFamilyIncome(scholarshipFormDto.getLastInfoDto().getTotalFamilyIncome());
        lastInfo.setTotalFamilyExpensive(scholarshipFormDto.getLastInfoDto().getTotalFamilyExpensive());
        lastInfo.setTotalMontylyDebt(scholarshipFormDto.getLastInfoDto().getTotalMontylyDebt());
        
        lastInfoRepository.save(lastInfo);
        
        
        FamilyStatus familyStatus = new FamilyStatus();
        familyStatus.setStudentBasicInfo(studentBasicInfo);
        familyStatus.setFamilyStatusOption(scholarshipFormDto.getFamilyStatusDto().getFamilyStatusOption());
        familyStatus.setAdditionalDetails(scholarshipFormDto.getFamilyStatusDto().getAdditionalDetails());
        familyStatus.setHousePhoto1(scholarshipFormDto.getFamilyStatusDto().getHousePhoto1());
        familyStatus.setHousePhoto2(scholarshipFormDto.getFamilyStatusDto().getHousePhoto2());
        familyStatus.setHousePhoto3(scholarshipFormDto.getFamilyStatusDto().getHousePhoto3());
        familyStatus.setHousePhoto4(scholarshipFormDto.getFamilyStatusDto().getHousePhoto4());
        familyStatusRepo.save(familyStatus);
        
        
        for (ScholarshipHistoryDto scholarshipHistoryDto : scholarshipFormDto.getScholarshipHistoryDtos()) {
            ScholarshipHistory scholarshipHistory = new ScholarshipHistory();
            scholarshipHistory.setStudent_id(studentBasicInfo.getStudent_id());
            scholarshipHistory.setScholarBefore(scholarshipHistoryDto.isScholarBefore());
            scholarshipHistory.setScholarName(scholarshipHistoryDto.getScholarName());
            scholarshipHistory.setRecieveYear(scholarshipHistoryDto.getRecieveYear());
            scholarshipHistory.setScholarAmount(scholarshipHistoryDto.getScholarAmount());
            scholarshipHistory.setBasicInfo(studentBasicInfo);
            scholarshipHistoryRepository.save(scholarshipHistory);
        }
        
        for (LoanHistoryDto loanHistoryDto : scholarshipFormDto.getLoanHistoryDtos()) {
            LoanHistory loanHistory = new LoanHistory();
            loanHistory.setStudent_id(studentBasicInfo.getStudent_id()); 
            loanHistory.setBasicInfo(studentBasicInfo);
            loanHistory.setLoanYearStart(loanHistoryDto.getLoanYearStart());
            loanHistory.setLoanYearEnd(loanHistoryDto.getLoanYearEnd());
            loanHistory.setLoanAmount(loanHistoryDto.getLoanAmount());

            loanHistoryRepo.save(loanHistory); 
            }
        
        for (SiblingInfoDto siblingInfoDto : scholarshipFormDto.getSiblingInfoDtos()) {
            SiblingInfo siblingInfo = new SiblingInfo();
            siblingInfo.setBasicInfo(studentBasicInfo);
            siblingInfo.setSibling_order(siblingInfoDto.getSibling_order());
            siblingInfo.setSibling_Name(siblingInfoDto.getSibling_Name());
            siblingInfo.setSibling_birthday(siblingInfoDto.getSibling_birthday());
            siblingInfo.setSibling_age(siblingInfoDto.getSibling_age());
            siblingInfo.setSibling_occupation(siblingInfoDto.getSibling_occupation());
            siblingInfo.setSibling_education(siblingInfoDto.getSibling_education());
            siblingInfo.setSibling_monthlyIncome(siblingInfoDto.getSibling_monthlyIncome());
            siblingInfoRepository.save(siblingInfo);
        }
        
        FatherInfo fatherInfo = new FatherInfo();
        fatherInfo.setStudentBasicInfo(studentBasicInfo);
        fatherInfo.setName(scholarshipFormDto.getFatherInfoDto().getName());
        fatherInfo.setAge(scholarshipFormDto.getFatherInfoDto().getAge());
        fatherInfo.setOccupation(scholarshipFormDto.getFatherInfoDto().getOccupation());
        fatherInfo.setPostion(scholarshipFormDto.getFatherInfoDto().getPostion());
        fatherInfo.setMonthy_income(scholarshipFormDto.getFatherInfoDto().getMonthy_income());
        fatherInfo.setYearly_income(scholarshipFormDto.getFatherInfoDto().getYearly_income());
        fatherInfo.setLandOwned_rent_Rai(scholarshipFormDto.getFatherInfoDto().getLandOwned_rent_Rai());
        fatherInfo.setPhone_Number(scholarshipFormDto.getFatherInfoDto().getPhone_Number());

        fatherInfo.setCity_town_village(scholarshipFormDto.getFatherInfoDto().getCity_town_village());
        fatherInfo.setHouseNum(scholarshipFormDto.getFatherInfoDto().getHouseNum());
        fatherInfo.setMoo(scholarshipFormDto.getFatherInfoDto().getMoo());
        fatherInfo.setRoad(scholarshipFormDto.getFatherInfoDto().getRoad());
        fatherInfo.setSubDistrict(scholarshipFormDto.getFatherInfoDto().getSubDistrict());
        fatherInfo.setDistrict(scholarshipFormDto.getFatherInfoDto().getDistrict());
        fatherInfo.setProvince(scholarshipFormDto.getFatherInfoDto().getProvince());
        fatherInfo.setPostal_Code(scholarshipFormDto.getFatherInfoDto().getPostal_Code());
        fatherInfo.setHome_phone_Number(scholarshipFormDto.getFatherInfoDto().getHome_phone_Number());

        fatherInfo.setWork_place(scholarshipFormDto.getFatherInfoDto().getWork_place());
        fatherInfo.setNum(scholarshipFormDto.getFatherInfoDto().getNum());
        fatherInfo.setWork_moo(scholarshipFormDto.getFatherInfoDto().getWork_moo());
        fatherInfo.setWork_road(scholarshipFormDto.getFatherInfoDto().getWork_road());
        fatherInfo.setWork_subDistrict(scholarshipFormDto.getFatherInfoDto().getWork_subDistrict());
        fatherInfo.setWork_district(scholarshipFormDto.getFatherInfoDto().getWork_district());
        fatherInfo.setWork_province(scholarshipFormDto.getFatherInfoDto().getWork_province());
        fatherInfo.setWork_postal_Code(scholarshipFormDto.getFatherInfoDto().getWork_postal_Code());
        fatherInfo.setWork_phone_Number(scholarshipFormDto.getFatherInfoDto().getWork_phone_Number());

        fatherInfoRepo.save(fatherInfo);
        
        
        MotherInfo motherInfo = new MotherInfo();
        motherInfo.setStudentBasicInfo(studentBasicInfo);
        motherInfo.setName(scholarshipFormDto.getMotherInfoDto().getName());
        motherInfo.setAge(scholarshipFormDto.getMotherInfoDto().getAge());
        motherInfo.setOccupation(scholarshipFormDto.getMotherInfoDto().getOccupation());
        motherInfo.setPostion(scholarshipFormDto.getMotherInfoDto().getPostion());
        motherInfo.setMonthy_income(scholarshipFormDto.getMotherInfoDto().getMonthy_income());
        motherInfo.setYearly_income(scholarshipFormDto.getMotherInfoDto().getYearly_income());
        motherInfo.setLandOwned_rent_Rai(scholarshipFormDto.getMotherInfoDto().getLandOwned_rent_Rai());
        motherInfo.setPhone_Number(scholarshipFormDto.getMotherInfoDto().getPhone_Number());

        motherInfo.setCity_town_village(scholarshipFormDto.getMotherInfoDto().getCity_town_village());
        motherInfo.setHouseNum(scholarshipFormDto.getMotherInfoDto().getHouseNum());
        motherInfo.setMoo(scholarshipFormDto.getMotherInfoDto().getMoo());
        motherInfo.setRoad(scholarshipFormDto.getMotherInfoDto().getRoad());
        motherInfo.setSubDistrict(scholarshipFormDto.getMotherInfoDto().getSubDistrict());
        motherInfo.setDistrict(scholarshipFormDto.getMotherInfoDto().getDistrict());
        motherInfo.setProvince(scholarshipFormDto.getMotherInfoDto().getProvince());
        motherInfo.setPostal_Code(scholarshipFormDto.getMotherInfoDto().getPostal_Code());
        motherInfo.setHome_phone_Number(scholarshipFormDto.getMotherInfoDto().getHome_phone_Number());

        motherInfo.setWork_place(scholarshipFormDto.getMotherInfoDto().getWork_place());
        motherInfo.setNum(scholarshipFormDto.getMotherInfoDto().getNum());
        motherInfo.setWork_moo(scholarshipFormDto.getMotherInfoDto().getWork_moo());
        motherInfo.setWork_road(scholarshipFormDto.getMotherInfoDto().getWork_road());
        motherInfo.setWork_subDistrict(scholarshipFormDto.getMotherInfoDto().getWork_subDistrict());
        motherInfo.setWork_district(scholarshipFormDto.getMotherInfoDto().getWork_district());
        motherInfo.setWork_province(scholarshipFormDto.getMotherInfoDto().getWork_province());
        motherInfo.setWork_postal_Code(scholarshipFormDto.getMotherInfoDto().getWork_postal_Code());
        motherInfo.setWork_phone_Number(scholarshipFormDto.getMotherInfoDto().getWork_phone_Number());

        motherInfoRepo.save(motherInfo);
        
     
        GurdianInfo gurdianInfo = new GurdianInfo();
        gurdianInfo.setStudentBasicInfo(studentBasicInfo); 
        gurdianInfo.setGurdian_name(scholarshipFormDto.getGurdianInfoDto().getGurdian_name());
        gurdianInfo.setGurdian_relationship(scholarshipFormDto.getGurdianInfoDto().getGurdian_relationship());
        gurdianInfo.setGurdian_monthlySupport(scholarshipFormDto.getGurdianInfoDto().getGurdian_monthlySupport());
        gurdianInfo.setGurdian_occupation(scholarshipFormDto.getGurdianInfoDto().getGurdian_occupation());
        gurdianInfo.setGurdian_position(scholarshipFormDto.getGurdianInfoDto().getGurdian_position());
        gurdianInfo.setGurdian_monthlyIncome(scholarshipFormDto.getGurdianInfoDto().getGurdian_monthlyIncome());
        gurdianInfo.setGurdian_yearlyIncome(scholarshipFormDto.getGurdianInfoDto().getGurdian_yearlyIncome());
        gurdianInfo.setGurdian_landOwned_rent_Rai(scholarshipFormDto.getGurdianInfoDto().getGurdian_landOwned_rent_Rai());
        gurdianInfo.setGurdian_phoneNumber(scholarshipFormDto.getGurdianInfoDto().getGurdian_phoneNumber());

        
        gurdianInfo.setCity_town_village(scholarshipFormDto.getGurdianInfoDto().getCity_town_village());
        gurdianInfo.setHouseNum(scholarshipFormDto.getGurdianInfoDto().getHouseNum());
        gurdianInfo.setMoo(scholarshipFormDto.getGurdianInfoDto().getMoo());
        gurdianInfo.setRoad(scholarshipFormDto.getGurdianInfoDto().getRoad());
        gurdianInfo.setSubDistrict(scholarshipFormDto.getGurdianInfoDto().getSubDistrict());
        gurdianInfo.setDistrict(scholarshipFormDto.getGurdianInfoDto().getDistrict());
        gurdianInfo.setProvince(scholarshipFormDto.getGurdianInfoDto().getProvince());
        gurdianInfo.setPostal_Code(scholarshipFormDto.getGurdianInfoDto().getPostal_Code());
        gurdianInfo.setHome_phone_Number(scholarshipFormDto.getGurdianInfoDto().getHome_phone_Number());

        
        gurdianInfo.setWork_place(scholarshipFormDto.getGurdianInfoDto().getWork_place());
        gurdianInfo.setNum(scholarshipFormDto.getGurdianInfoDto().getNum());
        gurdianInfo.setWork_moo(scholarshipFormDto.getGurdianInfoDto().getWork_moo());
        gurdianInfo.setWork_road(scholarshipFormDto.getGurdianInfoDto().getWork_road());
        gurdianInfo.setWork_subDistrict(scholarshipFormDto.getGurdianInfoDto().getWork_subDistrict());
        gurdianInfo.setWork_district(scholarshipFormDto.getGurdianInfoDto().getWork_district());
        gurdianInfo.setWork_province(scholarshipFormDto.getGurdianInfoDto().getWork_province());
        gurdianInfo.setWork_postal_Code(scholarshipFormDto.getGurdianInfoDto().getWork_postal_Code());
        gurdianInfo.setWork_phone_Number(scholarshipFormDto.getGurdianInfoDto().getWork_phone_Number());

        gurdianInfoRepo.save(gurdianInfo); 
        
        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setStudentBasicInfo(studentBasicInfo); 
        studentAddress.setPermanent_city_town_village(scholarshipFormDto.getStudentAddressDto().getPermanent_city_town_village());
        studentAddress.setPermanent_houseNum(scholarshipFormDto.getStudentAddressDto().getPermanent_houseNum());
        studentAddress.setPermanent_moo(scholarshipFormDto.getStudentAddressDto().getPermanent_moo());
        studentAddress.setPermanent_road(scholarshipFormDto.getStudentAddressDto().getPermanent_road());
        studentAddress.setPermanent_subDistrict(scholarshipFormDto.getStudentAddressDto().getPermanent_subDistrict());
        studentAddress.setPermanent_district(scholarshipFormDto.getStudentAddressDto().getPermanent_district());
        studentAddress.setPermanent_province(scholarshipFormDto.getStudentAddressDto().getPermanent_province());
        studentAddress.setPermanent_postalCode(scholarshipFormDto.getStudentAddressDto().getPermanent_postalCode());

        studentAddress.setCurrent_city_town_village(scholarshipFormDto.getStudentAddressDto().getCurrent_city_town_village());
        studentAddress.setCurrent_houseNum(scholarshipFormDto.getStudentAddressDto().getCurrent_houseNum());
        studentAddress.setCurrent_moo(scholarshipFormDto.getStudentAddressDto().getCurrent_moo());
        studentAddress.setCurrent_road(scholarshipFormDto.getStudentAddressDto().getCurrent_road());
        studentAddress.setCurrent_subDistrict(scholarshipFormDto.getStudentAddressDto().getCurrent_subDistrict());
        studentAddress.setCurrent_district(scholarshipFormDto.getStudentAddressDto().getCurrent_district());
        studentAddress.setCurrent_province(scholarshipFormDto.getStudentAddressDto().getCurrent_province());
        studentAddress.setCurrent_postalCode(scholarshipFormDto.getStudentAddressDto().getCurrent_postalCode());

        studentAddressRepo.save(studentAddress);
        
	}

}
