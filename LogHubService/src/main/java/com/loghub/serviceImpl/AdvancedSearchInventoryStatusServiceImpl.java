package com.loghub.serviceImpl;

import com.loghub.dao.AdvancedSearchInventoryStatusDao;
import com.loghub.daoImpl.AdvancedSearchInventoryStatusDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.AdvancedSearchInventoryStatusService;

public class AdvancedSearchInventoryStatusServiceImpl implements AdvancedSearchInventoryStatusService{

	AdvancedSearchInventoryStatusDao advancedSearchDao = new AdvancedSearchInventoryStatusDaoImpl(); 
	public ResponseModel getAdvancedInventoryStatusSearch(String advancePartNo, String advDescr, String partRadio) {
		
		
		return advancedSearchDao.getAdvancedInventoryStatusSearch(advancePartNo, advDescr, partRadio);
	}

}
