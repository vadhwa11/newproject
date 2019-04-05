package com.icg.dao;

import java.util.List;

import com.icg.model.Currency;
import com.icg.model.CurrencyDTO;

public interface SearchCurrencyDao {
	
	List<CurrencyDTO> getSearchCurrency(String currencyName);

}
