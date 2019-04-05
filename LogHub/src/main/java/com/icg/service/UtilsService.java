package com.icg.service;

import java.util.List;

import com.icg.model.Currency;
import com.icg.model.Depot;
import com.icg.model.Uom;

public interface UtilsService {

	List<Depot> getDepot();
	List<Currency> getCurrency();
	List<Uom> getUom();
	String getMaxSku();
}
