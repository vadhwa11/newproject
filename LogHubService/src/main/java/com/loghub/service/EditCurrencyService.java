package com.loghub.service;

import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.ResponseModel;

public interface EditCurrencyService {
	
	
	public ResponseModel editCurrency(String currencyName,String currencyValue);
}
