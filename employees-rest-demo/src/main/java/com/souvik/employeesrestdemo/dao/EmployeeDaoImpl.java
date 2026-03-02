package com.souvik.employeesrestdemo.dao;

import com.souvik.employeesrestdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
