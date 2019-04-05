package com.loghub.service;

import com.loghub.dao.DepoDao;
import com.loghub.daoImpl.DepoDaoImpl;
import com.loghub.dto.ResponseModel;

public class DepoServiceImpl implements DepoService{

	DepoDao depoDao = new DepoDaoImpl();
	public ResponseModel getDepoList(int depoId) {
		
		return depoDao.getDepoList(depoId);
	}

}
