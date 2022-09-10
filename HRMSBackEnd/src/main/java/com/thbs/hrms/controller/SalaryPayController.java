package com.thbs.hrms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.hrms.entity.SalaryPay;
import com.thbs.hrms.service.SalaryPayService;

@RestController
@CrossOrigin(origins = "*")
public class SalaryPayController 
{
	@Autowired
	private SalaryPayService salaryPayService;
	@GetMapping("/salaries")
	List<SalaryPay> getAll()
	{
		return salaryPayService.getAll();
	}
	@GetMapping("/salaries/{empId}/{year}/{month}")
	Optional<SalaryPay> getSalaryPay(@PathVariable Long empId,@PathVariable int year,@PathVariable int month)
	{
		return salaryPayService.getSalaryPay(empId,year,month);
	}
	@PostMapping("/salaries")
	SalaryPay save(@RequestBody SalaryPay salaryPay)
	{
		return salaryPayService.saveSalaryPay(salaryPay);
	}
}
