package com.souvik.employeecrudwithspringdatajpa.dao;

import com.souvik.employeecrudwithspringdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
