package com.te.employeemanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.employeemanagementservice.dto.Employee;
import com.te.employeemanagementservice.dto.User;
import com.te.employeemanagementservice.service.EmployeeService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://192.168.43.135:3000")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/signIn")
	private ResponseEntity<?> signIn(String email, String password) {
		try {
			service.signIn(email, password);
			return new ResponseEntity<String>("Sign in successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateData")
	public ResponseEntity<?> updateData(@RequestBody Employee employee) {
		try {
			service.updateData(employee);
			return new ResponseEntity<>("Data Updated Sucessfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Data Not updated Sucessfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	private ResponseEntity<?> register(@RequestBody User user) {
		try {
			service.register(user);
			return new ResponseEntity<String>("register successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("somthing went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add")
	private ResponseEntity<?> add(@RequestBody Employee employee) {
		try {
			service.add(employee);
			return new ResponseEntity<String>("data added successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("data not added successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteData")
	private ResponseEntity<?> deleteData(int empId) {
		try {
			service.deleteData(empId);
			return new ResponseEntity<String>("Data Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Data not Deleted successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/allData")
	private ResponseEntity<?> allData() {
		Iterable<Employee> employees = null;
		try {
			employees = service.allData();
			return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
