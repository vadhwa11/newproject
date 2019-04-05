package com.loghub.serviceImpl;

import com.loghub.dao.SearchInventoryDetalisDao;
import com.loghub.daoImpl.SearchInventoryDetalisDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchInventoryDetalisService;

public class SearchInventoryDetalisServiceImpl implements SearchInventoryDetalisService{
		
	SearchInventoryDetalisDao searchDao =new SearchInventoryDetalisDaoImpl();
		
	public ResponseModel getInventoryDetailsSearch(String partNo, String desc, String depot) {
		return searchDao.getInventoryDetalisSearch(partNo, desc,depot);
	}

}
