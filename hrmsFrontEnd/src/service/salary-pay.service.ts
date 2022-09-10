import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalaryPay } from 'src/model/salary-pay';

@Injectable({
	providedIn: 'root'
})
export class SalaryPayService {
	private baseURL = "http://13.233.250.68:8080/salaries";
	constructor(private httpClient: HttpClient) { }
	getPaySlipList(): Observable<SalaryPay[]> {
		return this.httpClient.get<SalaryPay[]>(`${this.baseURL}`);
	}
	createSalarySlip(salaryPay: SalaryPay): Observable<Object> {
		return this.httpClient.post(`${this.baseURL}`, salaryPay);
	}
	getSalaryPayByEmpIdAndYearAndMonth(empId: number,year: number,month: number): Observable<SalaryPay>{
		return this.httpClient.get<SalaryPay>(`${this.baseURL}/${empId}/${year}/${month}`);
	}
}
