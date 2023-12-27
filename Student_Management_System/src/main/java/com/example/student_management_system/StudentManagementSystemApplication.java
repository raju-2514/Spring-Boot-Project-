package com.example.student_management_system;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public void run(String... args) throws Exception {
//        Student student1=new Student("Raju","Biswas","raju@gmail.com");
//       studentRepo.save(student1);
//        Student student2=new Student("rana","rs","rana@gmail.com");
//        studentRepo.save(student2);
//        Student student3=new Student("sourav","barman","sourab@gmail.com");
//        studentRepo.save(student3);
    }
}
