import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalaryPay } from 'src/model/salary-pay';
import { SalaryPayService } from 'src/service/salary-pay.service';

@Component({
	selector: 'app-payslip-list',
	templateUrl: './payslip-list.component.html',
	styleUrls: ['./payslip-list.component.css']
})
export class PayslipListComponent implements OnInit {
	
	payslips!: SalaryPay[];
	constructor(private salaryPayService: SalaryPayService, private router: Router) { }

	ngOnInit(): void {
		this.getPaySlips();
	}
	private getPaySlips()
	{
		this.salaryPayService.getPaySlipList().subscribe(
			data =>{
				this.payslips = data;
		});
	}
	salarySlipDetails(id: number, year: number, month: number)
	{
		this.router.navigate(['salaryslip-details', id, year, month]);
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
