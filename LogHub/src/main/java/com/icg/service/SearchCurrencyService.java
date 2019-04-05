package com.icg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icg.model.Currency;
import com.icg.model.CurrencyDTO;

@Service
public interface SearchCurrencyService {
	
	List<CurrencyDTO> getSearchCurrency(String currencyName);

}
