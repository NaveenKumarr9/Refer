package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;

	public String getGrade(Student student) {

		if (student.getMarks() > 100)
			return "Invalid Marks";
		if (student.getMarks() >= 90)
			return student.getName() + " Got grade - A";
		if (student.getMarks() >= 80)
			return student.getName() + " Got Grade - B";
		if (student.getMarks() >= 70)
			return student.getName() + " Got Grade - C";
		return student.getName() + " Is Fail";
	}

	public Student saveStudent(Student student) {
		if (student.getMarks() > 100)
			student.setGrade("Invalid");
		else if (student.getMarks() >= 90)
			student.setGrade("A");
		else if (student.getMarks() >= 80)
			student.setGrade("B");
		else if (student.getMarks() >= 70)
			student.setGrade("C");
		else
			student.setGrade("Fail");
		return studentRepo.save(student);

	}

	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}

}
