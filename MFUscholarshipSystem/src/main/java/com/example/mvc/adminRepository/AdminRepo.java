package com.example.mvc.adminRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.mvc.AdminEntity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Long>{

}
