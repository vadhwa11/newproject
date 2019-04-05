package com.loghub.serviceImpl;

import java.util.List;

import com.loghub.dao.AddCurrencyDao;
import com.loghub.dao.LoginDao;
import com.loghub.daoImpl.AddCurrencyDaoImpl;
import com.loghub.daoImpl.LoginDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.AddCurrencyService;

public class AddCurrencyServiceImpl implements AddCurrencyService{

	
	AddCurrencyDao addCurrencyDao=new AddCurrencyDaoImpl();
	
	public ResponseModel addCurrency(String currencyName, String currencyValue) {
		AddCurrencyDao addCurrencyDao=new AddCurrencyDaoImpl();
		System.out.println(" in add service impl .....");
		return addCurrencyDao.addCurrency(currencyName, currencyValue);	
	}

	public List<String> duplicateCurrencyName() {
		// TODO Auto-generated method stub
		return addCurrencyDao.duplicateCurrency();	
	
	}

}
