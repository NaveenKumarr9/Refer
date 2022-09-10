package com.thbs.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.hrms.entity.Employee;
import com.thbs.hrms.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	public Optional<Employee> getEmployee(Long id) {
		return employeeRepository.findById(id);
	}
	public Employee updateEmployee(Long id,Employee emp) 
	{
		return employeeRepository.findById(id).map(
				employee ->{
					employee.setName(emp.getName());
					employee.setEmail(emp.getEmail());
					employee.setAddress(emp.getAddress());
					employee.setDepartment(emp.getDepartment());
					employee.setContactNo(emp.getContactNo());
					employee.setJoiningDate(emp.getJoiningDate());
					employee.setSalary(emp.getSalary());
					return employeeRepository.save(employee);
				}).orElseGet(() -> {
					emp.setId(id);
					return employeeRepository.save(emp);
				});
	}

	public Employee getById(Long empId) {
		return employeeRepository.getById(empId);
	}
}
