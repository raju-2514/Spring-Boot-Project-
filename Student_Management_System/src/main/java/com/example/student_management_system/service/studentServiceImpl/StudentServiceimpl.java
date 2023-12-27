package com.example.student_management_system.service.studentServiceImpl;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.repository.StudentRepo;
import com.example.student_management_system.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    private StudentRepo studentRepos;

    public StudentServiceimpl(StudentRepo studentRepos) {
        super();
        this.studentRepos = studentRepos;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepos.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepos.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepos.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepos.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepos.deleteById(id);
    }
}
