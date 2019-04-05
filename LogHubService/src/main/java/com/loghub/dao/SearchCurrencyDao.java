package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchCurrencyDao {
	
	public ResponseModel getCurrencyList(String currencyName, String currencyValue);

}
