package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.StudentAddress;

@Repository
public interface StudentAddressRepo extends CrudRepository<StudentAddress, Long>{

}
