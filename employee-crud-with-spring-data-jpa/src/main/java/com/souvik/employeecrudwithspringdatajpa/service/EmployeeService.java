package com.souvik.employeecrudwithspringdatajpa.service;

import com.souvik.employeecrudwithspringdatajpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(Integer id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Integer id);
}
