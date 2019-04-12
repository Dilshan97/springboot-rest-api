package com.dilshan.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dilshan.springbootrestapiexample.repository.EmployeeRepository;
import com.springbootrestapiexample.model.Employee;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	// SAVE AN EMPLOYEE
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	// SEARCH ALL EMPLOYEES
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	// GET AN EMPLOYEE
	public Employee findOne(Long empId) {
		Optional<Employee> op = employeeRepository.findById(empId);
		
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
	//  DELETE AN EMPLOYEE by id
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
}
