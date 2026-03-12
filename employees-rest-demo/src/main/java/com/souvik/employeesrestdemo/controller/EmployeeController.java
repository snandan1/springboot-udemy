package com.souvik.employeesrestdemo.controller;

import com.souvik.employeesrestdemo.entity.Employee;
import com.souvik.employeesrestdemo.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JsonMapper jsonMapper;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    @Transactional
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    @Transactional
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee employeeToUpdate = employeeService.findById(employeeId);

        if (employeeToUpdate == null) {
            throw new EntityNotFoundException("Employee with id: " + employeeId + " not found");
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee Id cannot be part of the update payload");
        }

        Employee employeeToBePatched = jsonMapper.updateValue(employeeToUpdate, patchPayload);

        return employeeService.save(employeeToBePatched);
    }

    @DeleteMapping("/employees/{employeeId}")
    @Transactional
    public String deleteEmployee(@PathVariable int employeeId) {
        if (employeeService.findById(employeeId) == null) {
            throw new EntityNotFoundException("Employee with id " + employeeId + " does not exist");
        }
        employeeService.deleteById(employeeId);

        return "Employee with id: " + employeeId + " deleted";
    }
}
