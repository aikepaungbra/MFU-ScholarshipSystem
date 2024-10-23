package com.example.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Entity.SiblingInfo;
import com.example.mvc.helper.SiblingInfoId;


@Repository
public interface SiblingInfoRepo extends CrudRepository<SiblingInfo, SiblingInfoId>{

}
