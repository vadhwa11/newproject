package com.loghub.serviceImpl;

import com.loghub.dao.SearchLastPurchasePriceDao;
import com.loghub.daoImpl.SearchLastPurchasePriceDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchLastPurchasePriceService;

public class SearchLastPurchasePriceServiceImpl implements SearchLastPurchasePriceService{

	SearchLastPurchasePriceDao searchLastPurchasePriceDao =new SearchLastPurchasePriceDaoImpl();
	public ResponseModel getLastPurchasePrice(String partNo) {		
		
		return searchLastPurchasePriceDao.getLastPurchasePrice(partNo);
	}

}
