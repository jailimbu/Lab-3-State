package com.login.repository;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository{
	
	public LoginRepositoryImpl()
	{

	}
	
	@Override
	public boolean checkLogin(String userName, String password)
	{
		if(userName.equals("jai") && password.equals("pass"))
			return true;
		return false;
	}
}
