package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.StudentBasicInfo;


@Repository
public interface StudentBasicInfoRepo extends CrudRepository<StudentBasicInfo, Long>{

}
