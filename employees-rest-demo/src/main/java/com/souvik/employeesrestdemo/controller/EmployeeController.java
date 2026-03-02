package com.souvik.employeesrestdemo.controller;

import com.souvik.employeesrestdemo.entity.Employee;
import com.souvik.employeesrestdemo.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
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
    public String deleteEmployee(@PathVariable int employeeId) {
        if (employeeService.findById(employeeId) == null) {
            throw new EntityNotFoundException("Employee with id " + employeeId + " does not exist");
        }
        employeeService.deleteById(employeeId);

        return "Employee with id: " + employeeId + " deleted";
    }
}
