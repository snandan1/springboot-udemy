package com.souvik.employeesrestdemo.dao;

import com.souvik.employeesrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(Integer id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Integer id);
}
