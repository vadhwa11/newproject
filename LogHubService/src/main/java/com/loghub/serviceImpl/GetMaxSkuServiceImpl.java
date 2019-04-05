package com.loghub.serviceImpl;

import com.loghub.dao.GetMaxSkuDao;
import com.loghub.daoImpl.GetMaxSkuDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.GetMaxSkuService;

public class GetMaxSkuServiceImpl implements GetMaxSkuService {

	GetMaxSkuDao getMaxSkuDao = new GetMaxSkuDaoImpl();
	public ResponseModel getMaxSku() {
		
		return getMaxSkuDao.getMaxSku();
	}

}
