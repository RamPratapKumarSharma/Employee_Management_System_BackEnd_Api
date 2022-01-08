package com.te.employeemanagementservice.service;

import com.te.employeemanagementservice.dto.Employee;
import com.te.employeemanagementservice.dto.User;

public interface EmployeeService {

	public void signIn(String email, String password);

	public Employee updateData(Employee employee);

	public void register(User user);

	public Employee add(Employee employee);

	public void deleteData(int empId);

	public Iterable<Employee> allData();
}
