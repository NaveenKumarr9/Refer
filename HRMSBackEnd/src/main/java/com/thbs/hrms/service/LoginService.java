package com.thbs.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.hrms.entity.Login;
import com.thbs.hrms.repository.LoginRepository;

@Service
public class LoginService 
{
	@Autowired
	private LoginRepository loginRepository;
	public Login autenticate(String userName,String password) {
		return loginRepository.findByUserNameAndPassword(userName,password);
	}
	public Login save(Login login) 
	{
		return loginRepository.save(login);
	}
	
}
