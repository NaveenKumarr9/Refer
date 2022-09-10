import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from 'src/service/employee.service';

@Component({
	selector: 'app-employee-list',
	templateUrl: './employee-list.component.html',
	styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

	employees!: Employee[];

	constructor(private employeeService: EmployeeService,
		private router: Router) { }

	ngOnInit(): void {
		this.getEmployees();
	}

	private getEmployees() {
		this.employeeService.getEmployeesList().subscribe(data => {
			this.employees = data;
		});
	}
	
	employeeDetails(id: number) {
		this.router.navigate(['employee-details', id]);
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
