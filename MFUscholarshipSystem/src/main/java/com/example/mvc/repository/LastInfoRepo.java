package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.LastInfo;

@Repository
public interface LastInfoRepo extends CrudRepository<LastInfo, Long>{

}
