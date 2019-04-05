package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.UtilsDao;
import com.icg.model.Currency;
import com.icg.model.Depot;
import com.icg.model.Uom;

@Service
public class UtilsServiceImpl implements UtilsService {
	
	@Autowired
	UtilsDao utilsDao;

	@Override
	public List<Depot> getDepot() {
		
		return utilsDao.getDepot();
	}

	@Override
	public List<Currency> getCurrency() {

		return utilsDao.getCurrency();
	}

	@Override
	public List<Uom> getUom() {

		return utilsDao.getUom();
	}

	@Override
	public String getMaxSku() {
		
		return utilsDao.getMaxSku();
	}
	
	

}
