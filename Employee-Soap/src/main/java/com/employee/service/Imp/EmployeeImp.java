package com.employee.service.Imp;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee getEmployeeById(long employeeId) {

        Employee obj = employeeRepository.findByEmployeeId(employeeId);
        return obj;

    }

    @Override
    public void AddEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);

    }

}
