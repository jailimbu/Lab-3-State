package com.login.repository;


public interface LoginRepository {
	boolean checkLogin(String userName, String password);
}
