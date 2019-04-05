package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface LoginDao {
	
	public ResponseModel getLogin(String userName, String password);

}
