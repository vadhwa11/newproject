package com.loghub.dao;

import java.util.List;

import com.loghub.dto.ResponseModel;

public interface AddCurrencyDao {
public ResponseModel addCurrency(String currencyName,String currencyValue);
public List<String> duplicateCurrency();
}
