package com.souvik.employeesrestdemo.service;

import com.souvik.employeesrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(int id);
}
