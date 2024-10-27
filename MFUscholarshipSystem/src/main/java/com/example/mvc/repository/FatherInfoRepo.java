package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.FatherInfo;

@Repository
public interface FatherInfoRepo extends CrudRepository<FatherInfo, Long>{

}
