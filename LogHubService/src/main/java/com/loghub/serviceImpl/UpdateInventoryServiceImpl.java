package com.loghub.serviceImpl;

import com.loghub.dao.UpdateInventoryDao;
import com.loghub.daoImpl.UpdateInventoryDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.UpdateInventoryService;

public class UpdateInventoryServiceImpl implements UpdateInventoryService{
	
	UpdateInventoryDao updateInventoryDao = new UpdateInventoryDaoImpl();

	public ResponseModel updateInventoryDetails(String skuForUpdate,String sku, String uom, String depot, String icgQty, String equitment,
			String partNo, String sPartNo, String descr, String ledgerNo, String unitPrice, String currency,
			String cat, String msl, String xDept, String skuFinal) {
		
		return updateInventoryDao.updateInventoryDetails(skuForUpdate,sku,uom,depot,icgQty,equitment,partNo,
				sPartNo,descr,ledgerNo,unitPrice,currency,cat,msl,xDept,skuFinal);
	}

}
