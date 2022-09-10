import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { Leaves } from 'src/model/leaves';
import { SalaryPay } from 'src/model/salary-pay';
import { EmployeeService } from 'src/service/employee.service';
import { LeavesService } from 'src/service/leaves.service';
import { SalaryPayService } from 'src/service/salary-pay.service';

@Component({
	selector: 'app-salaryslip-details',
	templateUrl: './salaryslip-details.component.html',
	styleUrls: ['./salaryslip-details.component.css']
})
export class SalaryslipDetailsComponent implements OnInit {
	id!: number;
	month!: number;
	year!: number;
	employee!: Employee;
	leaves!: Leaves;
	salaryPay!: SalaryPay;
	constructor(private employeeService: EmployeeService, private leavesService: LeavesService, private salaryPayService: SalaryPayService, private route: ActivatedRoute, private router: Router) { }

	ngOnInit(): void {
		this.id = this.route.snapshot.params['id'];
		this.month = this.route.snapshot.params['month'];
		this.year = this.route.snapshot.params['year'];
		this.employee = new Employee();
		this.employeeService.getEmployeeById(this.id).subscribe(
			data => {
				this.employee = data;
			});
		this.leaves = new Leaves();
		this.leavesService.getLeavesByEmpIdAndYearAndMonth(this.id,this.year,this.month).subscribe(
			data => {
				this.leaves = data;
			});
		this.salaryPay = new SalaryPay();
		this.salaryPayService.getSalaryPayByEmpIdAndYearAndMonth(this.id,this.year,this.month).subscribe(
			data => {
				this.salaryPay = data;
			});
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
