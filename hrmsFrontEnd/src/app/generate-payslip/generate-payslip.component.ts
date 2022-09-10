import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalaryPay } from 'src/model/salary-pay';
import { SalaryPayService } from 'src/service/salary-pay.service';

@Component({
	selector: 'app-generate-payslip',
	templateUrl: './generate-payslip.component.html',
	styleUrls: ['./generate-payslip.component.css']
})
export class GeneratePayslipComponent implements OnInit {
	salaryPay: SalaryPay = new SalaryPay();
	constructor(private salaryPayService: SalaryPayService,
		private router: Router) { }

	ngOnInit(): void {
	}

	saveSalaryPay() {
		this.salaryPayService.createSalarySlip(this.salaryPay).subscribe(data => {
			console.log(data);
			this.goToSalaryList();
		},
			error => console.log(error));
	}
	goToSalaryList() {
		this.router.navigate(['/salaries']);
	}
	onSubmit() {
		console.log(this.salaryPay);
		this.saveSalaryPay();
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
