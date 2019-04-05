package com.loghub.serviceImpl;

import com.loghub.daoImpl.EditCurrencyDaoImpl;
import com.loghub.dto.CurrencyDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.service.EditCurrencyService;

public class EditCurrencyServiceImpl implements EditCurrencyService {

	EditCurrencyDaoImpl editcurencyobj=new EditCurrencyDaoImpl();
	
	public ResponseModel editCurrency(String currencyName,String currencyValue) {
		
			return editcurencyobj.editCurrency(currencyName, currencyValue);
		
	}

	
	
	
}
