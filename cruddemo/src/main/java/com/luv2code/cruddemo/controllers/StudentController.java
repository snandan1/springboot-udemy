package com.luv2code.cruddemo.controllers;

import com.luv2code.cruddemo.controllers.exception.StudentNotFoundException;
import com.luv2code.cruddemo.controllers.response.StudentErrorResponse;
import com.luv2code.cruddemo.models.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    private void loadStudents() {
        students = List.of(
                new Student("Ramesh", "Banerjee"),
                new Student("Timothy", "Chalamet"),
                new Student("Tom", "Cruise")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId < 0 || studentId > students.size()) {
            throw new StudentNotFoundException(String.format("Student with id %s not found", studentId));
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse
                .setMessage(studentNotFoundException.getMessage())
                .setStatus(HttpStatus.NOT_FOUND.value())
                .setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

}
