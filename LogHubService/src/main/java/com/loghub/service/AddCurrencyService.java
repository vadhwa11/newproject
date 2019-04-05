package com.loghub.service;

import java.util.List;

import com.loghub.dto.ResponseModel;

public interface AddCurrencyService {
public ResponseModel addCurrency(String currencyName,String currencyValue);
public List<String> duplicateCurrencyName();
}
