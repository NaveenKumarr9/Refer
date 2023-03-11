package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
   private EmployeeService employeeService;

    @GetMapping("/employee")
    List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/employee/id/{id}")
    Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/name/{name}")
    Employee getEmpByName(@PathVariable String name){
        return employeeService.getEmployeeByLastName(name);
    }


    @PostMapping("/employee")
    Employee addEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
        return  employee;
    }

    @PostMapping("/employees")
    List<Employee> addEmployees(@RequestBody List<Employee> employee){
        employeeService.addNewEmployees(employee);
        return employee;
    }

    @PutMapping("/employee/{id}")
    String updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
         employeeService.updateEmployee(id, employee);
         return "Updated employee details with id :" + id;
    }

    @DeleteMapping("employee/{id}")
    String deleteByStudentId(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return "Deleted with id: " + id;
    }

    @PatchMapping("/emp/{id}")
    String patchEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        employeeService.patchData(id, employee);
        return "Employee Details Updated with id : " + id;

    }
}
