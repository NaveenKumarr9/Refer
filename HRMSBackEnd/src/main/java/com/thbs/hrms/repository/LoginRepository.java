package com.thbs.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thbs.hrms.entity.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Long>
{

	Login findByUserNameAndPassword(String userName, String password);
	
}
