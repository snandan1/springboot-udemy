package com.souvik.employeecrudwithspringdatajpa.service;

import com.souvik.employeecrudwithspringdatajpa.dao.EmployeeRepository;
import com.souvik.employeecrudwithspringdatajpa.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        log.info("All employees = " + employeeRepository.findAll().size());
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
