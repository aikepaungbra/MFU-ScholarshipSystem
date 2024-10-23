package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.ScholarshipHistory;

@Repository
public interface ScholarshipHistoryRepo extends CrudRepository<ScholarshipHistory, Long>{

}
