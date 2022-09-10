import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/model/login';
import { LoginService } from 'src/service/login.service';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	login1!:Login;
	login: Login = new Login();
	constructor(private loginService: LoginService, private router: Router) { }

	ngOnInit(): void {
	}
	onSubmit()
	{
		this.loginService.authenticate(this.login).subscribe(data =>{
			this.login1 = data;
			console.log(data);
			if(data != null)
			{
				this.router.navigate(['employees']);
			}
			else
			{
				alert("Invalid User Name or Password");
			}
		});
	}
	
}
