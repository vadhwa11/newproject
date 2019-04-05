package com.loghub.dao;

import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.ResponseModel;

public interface EditCurrencyDao {

	public ResponseModel editCurrency(String currencyName,String currencyValue);
	
}
