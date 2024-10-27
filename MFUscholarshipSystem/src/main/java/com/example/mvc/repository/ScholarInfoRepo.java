package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.ScholarInfo;


@Repository
public interface ScholarInfoRepo extends CrudRepository<ScholarInfo, Integer>{

}
