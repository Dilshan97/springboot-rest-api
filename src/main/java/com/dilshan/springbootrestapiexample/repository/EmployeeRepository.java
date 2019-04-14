package com.dilshan.springbootrestapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapiexample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
