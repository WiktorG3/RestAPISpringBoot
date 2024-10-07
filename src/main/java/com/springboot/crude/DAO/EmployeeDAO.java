package com.springboot.crude.DAO;

import com.springboot.crude.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
