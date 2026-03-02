package com.souvik.employeesrestdemo.service;

import com.souvik.employeesrestdemo.dao.EmployeeDao;
import com.souvik.employeesrestdemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
