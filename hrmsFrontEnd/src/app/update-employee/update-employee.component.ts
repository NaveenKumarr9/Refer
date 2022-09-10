import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from 'src/service/employee.service';

@Component({
	selector: 'app-update-employee',
	templateUrl: './update-employee.component.html',
	styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

	id!:number;
	employee: Employee =new Employee();
	constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

	ngOnInit(): void {
		this.id = this.route.snapshot.params['id'];
		this.employeeService.getEmployeeById(this.id).subscribe(
			data => {
				this.employee = data;
			});
	}
	OnSubmit()
	{
		this.employeeService.updateEmployee(this.id, this.employee).subscribe(data =>{
			this.goToEmployeeList();
		});
	}
	goToEmployeeList()
	{
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
