package com.icg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.AddCurrencyDao;
import com.icg.model.Currency;

@Service
public class AddCurrencyServiceImpl implements AddCurrencyService {

	@Autowired
	AddCurrencyDao addCurrencyDao;
	
	@Override
	public String addCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return addCurrencyDao.addCurrency(currency);
	}

}
