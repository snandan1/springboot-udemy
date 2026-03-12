package com.souvik.employeesrestdemo.dao;

import com.souvik.employeesrestdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    public void deleteById(Integer id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
