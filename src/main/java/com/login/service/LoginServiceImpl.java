package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository loginRepository;
	@Override
	public boolean checkLogin(String userName, String password)
	{
		return loginRepository.checkLogin(userName, password);
	}
}
