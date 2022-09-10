import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from 'src/model/login';

@Injectable({
	providedIn: 'root'
})
export class LoginService {
	private baseURL = "http://13.233.250.68:8080/login";
	constructor(private httpClient: HttpClient) { }
	authenticate(login: Login): Observable<Login>
	{
		return this.httpClient.get<Login>(`${this.baseURL}/${login.userName}/${login.password}`);
	}
}
