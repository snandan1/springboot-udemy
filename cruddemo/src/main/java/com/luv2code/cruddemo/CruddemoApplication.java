package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    private final StudentDao studentDao;

    public CruddemoApplication(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            //    createMultipleStudents();
            findStudent();
            findAllStudents();
            queryForStudents("Tom");
            // updateStudent("Harry", "Harrison");
            // deleteStudent(5);
        };
    }

    private void findStudent() {
        Student studentFound = studentDao.findById(16);

        System.out.println("Student found = " + studentFound);
    }

    private void findAllStudents() {
        List<Student> studentList = studentDao.findAll();
        System.out.println("Found " + studentList.size() + " students");
        System.out.println(studentList);
        studentList.forEach(System.out::println);
    }

    private void queryForStudents(String pattern) {
//        String pattern = "Tom";
        List<Student> studentList = studentDao.findByName(pattern);
        System.out.printf("Results for searching for students having %s in the name: ", pattern);
        studentList.forEach(System.out::println);
    }

    private void createStudent(Student student) {
        System.out.println("Saving student: " + student);
        studentDao.save(student);
        System.out.println("Saved student: " + student.getId());
    }

    private void createMultipleStudents() {
        Student student1 = new Student("Tom", "Holland", "tom.holland@xyz.com");
        Student student2 = new Student("Ramesh", "Holland", "ramesh.holland@xyz.com");
        Student student3 = new Student("Harry", "Holland", "harry.holland@xyz.com");
        Student student4 = new Student("Will", "Holland", "will.holland@xyz.com");

        Arrays.asList(student1, student2, student3, student4).forEach(this::createStudent);
    }

    private void updateStudent(String firstName, String newFirstName) {
        List<Student> studentList = studentDao.findByName(firstName);

        studentList.stream()
                .map(student -> student.setFirstName(newFirstName))
                .forEach(studentDao::update);
    }

    private void deleteStudent(Integer id) {
        studentDao.delete(id);
    }
}
