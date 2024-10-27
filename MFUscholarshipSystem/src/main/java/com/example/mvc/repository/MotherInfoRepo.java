package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.MotherInfo;

@Repository
public interface MotherInfoRepo extends CrudRepository<MotherInfo, Long>{

}
