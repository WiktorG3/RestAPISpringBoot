package com.springboot.crude.service;

import com.springboot.crude.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
