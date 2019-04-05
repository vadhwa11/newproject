package com.icg.service;

import org.springframework.stereotype.Service;

@Service
public interface DeleteCurrencyService {
	
	String deleteCurrency(String currencyName);

}
