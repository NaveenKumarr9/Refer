package com.student.service;

import com.student.model.Student;
import java.util.List;

public interface StudentService {

    void addStudent(Student student);
    void updateStudent(Student student,int id);
    void deleteStudent(int studentId);

    Student getById(int studentId);
    List<Student> getAllStudents();
    List<Student> getByDepartment(String department);
}
