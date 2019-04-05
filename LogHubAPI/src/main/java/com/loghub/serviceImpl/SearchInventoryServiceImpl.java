package com.loghub.serviceImpl;

import com.loghub.dao.SearchInventoryDao;
import com.loghub.daoImpl.SearchInventoryDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchInventoryService;

public class SearchInventoryServiceImpl implements SearchInventoryService{

	SearchInventoryDao searchInventoryDao=new SearchInventoryDaoImpl();
	public ResponseModel getInventoryDetails(String sku) {
		
		return searchInventoryDao.getInventoryDetails(sku);
	}

}
