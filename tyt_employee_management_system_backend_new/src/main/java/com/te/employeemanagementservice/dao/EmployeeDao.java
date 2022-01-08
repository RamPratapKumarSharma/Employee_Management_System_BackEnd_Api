package com.te.employeemanagementservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.employeemanagementservice.dto.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
