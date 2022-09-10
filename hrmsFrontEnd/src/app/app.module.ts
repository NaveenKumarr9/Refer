import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { FormsModule } from '@angular/forms';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { LeavesComponent } from './leaves/leaves.component';
import { CreateLeavesComponent } from './create-leaves/create-leaves.component';
import { GeneratePayslipComponent } from './generate-payslip/generate-payslip.component';
import { PayslipListComponent } from './payslip-list/payslip-list.component';
import { SalaryslipDetailsComponent } from './salaryslip-details/salaryslip-details.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    UpdateEmployeeComponent,
    LeavesComponent,
    CreateLeavesComponent,
    GeneratePayslipComponent,
    PayslipListComponent,
    SalaryslipDetailsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
