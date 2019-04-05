package com.loghub.serviceImpl;

import com.loghub.dao.RefrenceForLPPDao;
import com.loghub.daoImpl.RefrenceForLPPDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.RefrenceForLPPService;

public class RefrenceForLPPServiceImpl implements RefrenceForLPPService{

	RefrenceForLPPDao refrenceForDao = new RefrenceForLPPDaoImpl();
	public ResponseModel gerRefForLPP(String sku) {
		
		return refrenceForDao.gerRefForLPP(sku);
	}

}
