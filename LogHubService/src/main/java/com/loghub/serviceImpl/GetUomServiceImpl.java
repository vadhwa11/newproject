package com.loghub.serviceImpl;

import com.loghub.dao.GetUomDao;
import com.loghub.daoImpl.GetUomDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.GetUomService;

public class GetUomServiceImpl implements GetUomService {

	GetUomDao getUomDao = new GetUomDaoImpl();
	
	public ResponseModel getUom() {
		
		return getUomDao.getUom();
	}
}
