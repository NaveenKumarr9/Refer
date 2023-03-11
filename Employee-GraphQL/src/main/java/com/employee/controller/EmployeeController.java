package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @QueryMapping("getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @QueryMapping("getEmployeeById")
    public Employee getEmployeeById(@Argument int id){
        return employeeService.getEmployeeById(id);
    }

    @MutationMapping("createEmployee")
    public Employee createEmployee(@Argument Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @MutationMapping("updateEmployee")
    public Employee updateEmployee(@Argument int id,@Argument Employee employee){
        return employeeService.updateData(id,employee);
    }

    @MutationMapping("deleteEmployeeById")
    public String deleteEmployeeById(@Argument int id){
        employeeService.deleteEmployeeById(id);
        return "Employee Deleted With id: "+id;
    }
}
