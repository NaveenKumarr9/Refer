package com.employee.service;

import com.employee.exception.EmployeeNotFound;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFound("Employee you are looking for not found"));
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id){
         employeeRepository.deleteById(id);
    }

    public Employee updateData(int id,Employee employee){
        return employeeRepository.findById(id).map(emp->{
            emp.setName(employee.getName());
            emp.setGender(employee.getGender());
            emp.setAge(employee.getAge());
            emp.setRole(employee.getRole());
            emp.setAddress(employee.getAddress());
            return employeeRepository.save(emp);
        }).orElseThrow(()->new EmployeeNotFound("Check Your Details and enter Correctly"));
    }
}
