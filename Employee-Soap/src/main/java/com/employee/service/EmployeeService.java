package com.employee.service;

import com.employee.model.Employee;

public interface EmployeeService {
    void AddEmployee(Employee employee);

    Employee getEmployeeById(long employeeId);

    void updateEmployee(Employee employee);

    void deleteEmployee(long employeeId);
}