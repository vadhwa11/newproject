package com.loghub.serviceImpl;

import com.loghub.dao.NacDao;
import com.loghub.daoImpl.NacDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.NacService;

public class NacServiceImpl implements NacService{

	NacDao nacDao = new NacDaoImpl();
	public ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate) {
		
		return nacDao.getNacDetails(partNo, depot, fromDate, toDate);
	}

}
