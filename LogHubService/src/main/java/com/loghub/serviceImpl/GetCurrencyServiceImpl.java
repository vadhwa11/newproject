package com.loghub.serviceImpl;

import com.loghub.dao.GetCurrencyDao;
import com.loghub.daoImpl.GetCurrencyDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.GetCurrencyService;

public class GetCurrencyServiceImpl implements GetCurrencyService {

	GetCurrencyDao getCurrencyDao = new GetCurrencyDaoImpl();
	
	public ResponseModel getCurrency() {
		
		return getCurrencyDao.getCurrency();
	}

}
