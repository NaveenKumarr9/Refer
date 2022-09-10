import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from 'src/service/employee.service';

@Component({
	selector: 'app-create-employee',
	templateUrl: './create-employee.component.html',
	styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

	employee: Employee = new Employee();
	constructor(private employeeService: EmployeeService,
		private router: Router) { }

	ngOnInit(): void {
	}

	saveEmployee() {
		this.employeeService.createEmployee(this.employee).subscribe(data => {
			console.log(data);
			this.goToEmployeeList();
		},
			error => console.log(error));
	}
	onSubmit() {
		console.log(this.employee);
		this.saveEmployee();
	}
	goToEmployeeList() {
		this.router.navigate(['/employees']);
	}
	addEmployee()
	{
		this.router.navigate(['/create-employee']);
	}
	leavesList()
	{
		this.router.navigate(['/leaves']);
	}
	addLeaves()
	{
		this.router.navigate(['/create-leaves']);
	}
	salarySlips()
	{
		this.router.navigate(['/salaries']);
	}
	generatePaySlip()
	{
		this.router.navigate(['/generate-payslip']);
	}
}
