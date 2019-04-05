package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryStatusDao {

	public ResponseModel getInventoryStatusSearch(String partNo, String desc, String depot,String sku, String equipment,String ledgerNo, String advancePartNo);
	
}