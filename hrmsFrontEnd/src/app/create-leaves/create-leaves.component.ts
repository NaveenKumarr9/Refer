import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Leaves } from 'src/model/leaves';
import { LeavesService } from 'src/service/leaves.service';

@Component({
	selector: 'app-create-leaves',
	templateUrl: './create-leaves.component.html',
	styleUrls: ['./create-leaves.component.css']
})
export class CreateLeavesComponent implements OnInit {
	leaves: Leaves = new Leaves();
	constructor(private leavesService: LeavesService, private router: Router) { }

	ngOnInit(): void {
	}
	saveLeaves() {
		this.leavesService.createLeaves(this.leaves).subscribe(data => {
			console.log(data);
			this.goToLeavesList();
		});
	}
	goToLeavesList() {
		this.router.navigate(['/leaves']);
	}
	onSubmit() {
		console.log(this.leaves);
		this.saveLeaves();
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
