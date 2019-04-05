package com.loghub.serviceImpl;

import com.loghub.dao.GetDepotDao;
import com.loghub.daoImpl.GetDepotDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.GetDepotService;

public class GetDepotServiceImpl implements GetDepotService{

	GetDepotDao getDepotDao = new GetDepotDaoImpl();
	
	public ResponseModel getDepot() {
		
		return getDepotDao.getDepot();
	}

}
