package com.store.meonggae.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.meonggae.user.login.dao.LoginDAO;
import com.store.meonggae.user.login.domain.LoginDomain;
import com.store.meonggae.user.login.vo.LoginVO;

@Service
public class LoginService {
	@Autowired
	private LoginDAO lDAO;
	
	public LoginDomain selectOneUser(LoginVO lVO) {
		return lDAO.login(lVO);
	}
}
