import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from 'src/model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
	
	private studentUrl: string;

  	constructor(private http: HttpClient) {
		this.studentUrl = 'http://localhost:8090/students';
 	}
 	public findAll(): Observable<Student[]>{
		return this.http.get<Student[]>(this.studentUrl);
	}
}
