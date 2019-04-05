package com.icg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.EditCurrencyDao;
import com.icg.model.Currency;

@Service
public class EditCurrencyServiceImpl implements EditCurrencyService {

	@Autowired
	EditCurrencyDao editCurrencyDao;
	
	
	@Override
	public String editCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return editCurrencyDao.editCurrency(currency);
	}

}
