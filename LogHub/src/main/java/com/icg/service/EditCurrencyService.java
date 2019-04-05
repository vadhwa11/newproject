package com.icg.service;

import org.springframework.stereotype.Service;

import com.icg.model.Currency;

@Service
public interface EditCurrencyService {

	String editCurrency(Currency currency);
}
