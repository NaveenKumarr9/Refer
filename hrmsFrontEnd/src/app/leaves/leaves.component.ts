import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Leaves } from 'src/model/leaves';
import { LeavesService } from 'src/service/leaves.service';

@Component({
	selector: 'app-leaves',
	templateUrl: './leaves.component.html',
	styleUrls: ['./leaves.component.css']
})
export class LeavesComponent implements OnInit {
	leaves!: Leaves[];
	constructor(private leavesService: LeavesService,private router: Router) { }

	ngOnInit(): void {
		this.getLeaves();
	}
	private getLeaves()
	{
		this.leavesService.getLeaves().subscribe(
			data => {
				this.leaves = data;
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
