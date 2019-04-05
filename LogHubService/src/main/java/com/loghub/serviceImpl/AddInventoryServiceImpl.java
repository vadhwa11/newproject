package com.loghub.serviceImpl;

import com.loghub.dao.AddInventoryDao;
import com.loghub.daoImpl.AddInventoryDaoImpl;
import com.loghub.dto.InventoryDTO;
import com.loghub.dto.ResponseModel;
import com.loghub.service.AddInventoryService;

public class AddInventoryServiceImpl implements AddInventoryService{
	
	AddInventoryDao addInventoryDao = new AddInventoryDaoImpl();

	public ResponseModel addInventoryDetails(String sku, String uom, String depot, String icgQty, String equitment, String partNo, String sPartNo, String descr, String ledgerNo, String unitPrice, String currency, String cat, String msl, String xDept, String skuFinal) {
		
		return addInventoryDao.addInventoryDetails(sku,uom,depot,icgQty,equitment,partNo,
				sPartNo,descr,ledgerNo,unitPrice,currency,cat,msl,xDept,skuFinal);
	}

	public ResponseModel addInventoryDetails(InventoryDTO inventory) {
		// TODO Auto-generated method stub
		return addInventoryDao.addInventoryDetails(inventory);
	}

}
