package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface LoginService {
	
	public ResponseModel getLogin(String userName, String password);

}
