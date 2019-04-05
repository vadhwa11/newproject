package com.icg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.DeleteCurrencyDao;

@Service
public class DeleteCurrencyServiceImpl implements DeleteCurrencyService{

	@Autowired
	DeleteCurrencyDao deleteCurrencyDao;
	
	@Override
	public String deleteCurrency(String currencyName) {
		
		return deleteCurrencyDao.deleteCurrency(currencyName);
	}

}
