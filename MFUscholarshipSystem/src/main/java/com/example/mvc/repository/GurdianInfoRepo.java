package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.GurdianInfo;

@Repository
public interface GurdianInfoRepo extends CrudRepository<GurdianInfo, Long>{

}
