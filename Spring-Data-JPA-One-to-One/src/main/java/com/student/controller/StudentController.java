package com.student.controller;

import com.student.model.Student;
import com.student.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("id/{id}")
    Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @GetMapping("department/{department}")
    List<Student> getByDepartment(@PathVariable String department){
       return studentService.getByDepartment(department);
    }

    @PostMapping("/save")
    Student addStudent(@RequestBody Student student){
    studentService.addStudent(student);
    return student;
    }

    @DeleteMapping("/delete/{id}")
    String deleteStudentById(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Deleted with id:" + id;
    }

    @PutMapping("/update/{id}")
    String updateStudent(@RequestBody Student student,@PathVariable int id){
        studentService.updateStudent(student,id);
        return "Updated student details with id :" + id;
    }

}
