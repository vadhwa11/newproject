package com.loghub.serviceImpl;

import com.loghub.dao.DeleteInventoryDao;
import com.loghub.daoImpl.DeleteInventoryDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.DeleteInventoryService;

public class DeleteInventoryServiceImpl implements DeleteInventoryService{

	DeleteInventoryDao deleteInventoryDao = new DeleteInventoryDaoImpl();
	
	public ResponseModel deleteInventoryDetails(String sku) {
		
		return deleteInventoryDao.deleteInventoryDetails(sku);
	}

}
