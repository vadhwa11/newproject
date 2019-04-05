package com.loghub.serviceImpl;

import com.loghub.dao.DeleteCurrencyDao;
import com.loghub.daoImpl.DeleteCurrencyDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.DeleteCurrencyService;

public class DeleteCurrencyServiceImpl implements DeleteCurrencyService{

	public ResponseModel deleteCurrency(String currencyName) {
		DeleteCurrencyDao deleteCurrencydao = new DeleteCurrencyDaoImpl();
		return deleteCurrencydao.deleteCurrency(currencyName);
	}

}
