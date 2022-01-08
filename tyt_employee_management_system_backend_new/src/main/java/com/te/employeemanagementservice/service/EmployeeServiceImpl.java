package com.te.employeemanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.te.employeemanagementservice.dao.EmployeeDao;
import com.te.employeemanagementservice.dao.UserDao;
import com.te.employeemanagementservice.dto.Employee;
import com.te.employeemanagementservice.dto.User;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	@Autowired
	public UserDao userDao;

	@Override
	public void signIn(String email, String password) {
		User user = userDao.findByEmail(email);
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException();
		}
	}

	@Override
	public Employee updateData(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public void register(User user) {
		User user2 = userDao.findByEmail(user.getEmail());
		if (user2 != null) {
			throw new RuntimeException();
		} else {
			userDao.save(user);
		}
	}

	@Override
	public Employee add(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public void deleteData(int empId) {
		employeeDao.delete(employeeDao.findById(empId).orElse(null));
	}

	@Override
	public Iterable<Employee> allData() {
		return employeeDao.findAll();
	}
}
