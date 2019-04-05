package com.loghub.serviceImpl;

import com.loghub.dao.SearchCurrencyDao;
import com.loghub.daoImpl.SearchCurrencyDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchCurrencyService;

public class SearchCurrencyServiceImpl implements SearchCurrencyService{

	SearchCurrencyDao searchCurrencyDao = new SearchCurrencyDaoImpl();
	public ResponseModel getCurrencyList(String currencyName, String currencyValue) {

		return searchCurrencyDao.getCurrencyList(currencyName, currencyValue);
	}

}
