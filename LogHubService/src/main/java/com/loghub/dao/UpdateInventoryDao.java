package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface UpdateInventoryDao {

	ResponseModel updateInventoryDetails(String skuForUpdate,String sku, String uom, String depot, String icgQty, String equitment,
			String partNo, String sPartNo, String descr, String ledgerNo, String unitPrice, String currency,
			String cat, String msl, String xDept, String skuFinal);

}
