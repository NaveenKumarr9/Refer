package com.thbs.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.hrms.entity.Employee;
import com.thbs.hrms.service.EmployeeService;


@RestController
@CrossOrigin(origins = "*")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/employees")
	List<Employee> getAll()
	{
		return employeeService.getAll();
	}
	@GetMapping("/employees/{id}")
	Optional<Employee> getEmployee(@PathVariable Long id)
	{
		return employeeService.getEmployee(id);
	}
	@PostMapping("/employees")
	Employee save(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id)
	{
		employeeService.deleteEmployee(id);
	}
	@PutMapping("/employees/{id}")
	Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(id,employee);
	}
}
