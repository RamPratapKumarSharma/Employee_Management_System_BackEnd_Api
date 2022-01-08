package com.te.employeemanagementservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.employeemanagementservice.dto.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	public User findByEmail(String email);
	
}
