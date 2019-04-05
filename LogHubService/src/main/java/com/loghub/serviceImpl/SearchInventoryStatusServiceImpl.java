package com.loghub.serviceImpl;

import com.loghub.dao.SearchInventoryStatusDao;
import com.loghub.daoImpl.SearchInventoryStatusDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchInventoryStatusService;

public class SearchInventoryStatusServiceImpl implements SearchInventoryStatusService{
	
	SearchInventoryStatusDao searchDao =new SearchInventoryStatusDaoImpl();

	/*public ResponseModel getInventoryStatusSearch(String partNo, String secondPartNo, String desc, String depot, String equipment) {
	return searchDao.getInventoryStatusSearch(partNo, secondPartNo, desc,depot,equipment);
}*/

	public ResponseModel getInventoryStatusSearch(String partNo, String desc, String depot,String sku, String equipment,String ledgerNo, String advancePartNo) {
		
		return searchDao.getInventoryStatusSearch(partNo, desc,depot,sku,equipment,ledgerNo,advancePartNo);
	}

	
}

