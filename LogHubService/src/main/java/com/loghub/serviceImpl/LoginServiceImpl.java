package com.loghub.serviceImpl;

import com.loghub.dao.LoginDao;
import com.loghub.daoImpl.LoginDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.LoginService;
/*
 * @RAJDEO
 * LOGIN SERVICE
 */
public class LoginServiceImpl implements LoginService{

	LoginDao loginDao=new LoginDaoImpl();
	public ResponseModel getLogin(String userName, String password) {
	return loginDao.getLogin(userName, password);	
	}

}
