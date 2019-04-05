package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchCurrencyService {
	public ResponseModel getCurrencyList(String currencyName, String currencyValue);

}
