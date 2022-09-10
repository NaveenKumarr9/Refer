import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { CreateLeavesComponent } from './create-leaves/create-leaves.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { GeneratePayslipComponent } from './generate-payslip/generate-payslip.component';
import { LeavesComponent } from './leaves/leaves.component';
import { LoginComponent } from './login/login.component';
import { PayslipListComponent } from './payslip-list/payslip-list.component';
import { SalaryslipDetailsComponent } from './salaryslip-details/salaryslip-details.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
	{ path: '', component: LoginComponent },
	{ path: 'employees', component: EmployeeListComponent },
	{ path: 'create-employee', component: CreateEmployeeComponent },
	{ path: 'employee-details/:id', component: EmployeeDetailsComponent },
	{ path: 'update-employee/:id', component: UpdateEmployeeComponent },
	{ path: 'leaves', component: LeavesComponent },
	{ path: 'create-leaves', component: CreateLeavesComponent },
	{ path: 'salaries', component: PayslipListComponent},
	{ path: 'generate-payslip', component: GeneratePayslipComponent},
	{ path: 'salaryslip-details/:id/:year/:month', component: SalaryslipDetailsComponent},
	{ path: 'salaryslip-details/:id', component: SalaryslipDetailsComponent},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
