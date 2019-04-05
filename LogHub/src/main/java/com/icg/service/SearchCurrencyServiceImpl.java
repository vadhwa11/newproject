package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.SearchCurrencyDao;
import com.icg.model.Currency;
import com.icg.model.CurrencyDTO;
@Service
public class SearchCurrencyServiceImpl implements SearchCurrencyService{

	@Autowired
	SearchCurrencyDao searchCurrencyDao;
	
	@Override
	public List<CurrencyDTO> getSearchCurrency(String currencyName) {
		
		return searchCurrencyDao.getSearchCurrency(currencyName);
	}

}
