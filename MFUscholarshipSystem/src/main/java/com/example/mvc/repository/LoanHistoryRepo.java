package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.LoanHistory;

@Repository
public interface LoanHistoryRepo extends CrudRepository<LoanHistory, Long>{

}
