package com.example.mvc.adminRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.mvc.AdminEntity.ScholarApplicants;

public interface ScholarApplicantsRepo extends CrudRepository<ScholarApplicants, Integer>{

}
