package com.employee.service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFound;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
   private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployeeDetails(){
        List<Employee> employeeList = employeeRepo.findAll();
        if (employeeList.isEmpty())
            throw new EmployeeNotFound("Employees Are Not Found");
        return employeeList;
    }

    public Employee getEmployeeById(Integer id){
       return employeeRepo.findById(id)
               .orElseThrow(()->new EmployeeNotFound("Employee not Found With Id: "+id));
    }

    public Employee getEmployeeByLastName(String lastName){
        return employeeRepo.getDetailsByLastName(lastName);
    }

    public void addNewEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void addNewEmployees(List<Employee> employee){
        employeeRepo.saveAll(employee);
    }

    public void updateEmployee(Integer id, Employee employee){
        employeeRepo.findById(id)
                .map(emp -> {
                    emp.setFirstName(employee.getFirstName());
                    emp.setLastName(employee.getLastName());
                    emp.setEmail(employee.getEmail());
                    emp.setRole(employee.getRole());
                    return employeeRepo.save(emp);

                }).orElseGet(() -> {
                    employee.setId(id);
                    return employeeRepo.save(employee);
                });
    }

    public void deleteEmployeeById(Integer id){
         employeeRepo.deleteById(id);
    }

    public void patchData(Integer id, Employee employee){
        Optional<Employee> emp = employeeRepo.findById(id);
        emp.get().setFirstName(employee.getFirstName());
        emp.get().setLastName(employee.getLastName());

        employeeRepo.save(emp.get());
    }
}
