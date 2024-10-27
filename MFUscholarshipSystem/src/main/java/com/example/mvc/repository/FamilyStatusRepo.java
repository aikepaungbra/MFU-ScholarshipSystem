package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.FamilyStatus;


@Repository
public interface FamilyStatusRepo extends CrudRepository<FamilyStatus, Long>{

}
