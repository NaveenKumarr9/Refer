package com.student.service.impl;

import com.student.exception.StudentNotFound;
import com.student.model.Student;
import com.student.repository.StudentRepo;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Student student,int id) {
        Student student1 = studentRepo.findById(id)
                .orElseThrow(()->new StudentNotFound("Student Not Found with Id: " + id));
        student1.setName(student.getName());
        student1.setDepartment(student.getDepartment());
        student1.setAddress(student.getAddress());
         studentRepo.save(student1);
    }

    @Override
    public void deleteStudent(int studentId) {
        Optional<Student> studentList = studentRepo.findById(studentId);
        if (studentList.isEmpty()){
            throw new StudentNotFound("Student Not Found with Id: " + studentId);
        }
        studentRepo.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return studentRepo.findById(studentId)
                .orElseThrow(()->new StudentNotFound("Student Not Found with id: " + studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty()){
            throw new StudentNotFound("Students Are Not Found Please try to add Students and try again.");
        }
        return studentList;
    }

    @Override
    public List<Student> getByDepartment(String department) {
        List<Student> studentList = studentRepo.findByDepartment(department);

        if (studentList.isEmpty()){
            throw new StudentNotFound("Student Not Found With Department: "+department);
        }
        return studentRepo.findByDepartment(department);
    }
}
