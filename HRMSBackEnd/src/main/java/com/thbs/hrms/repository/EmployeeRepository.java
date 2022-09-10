package com.thbs.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thbs.hrms.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	
}
