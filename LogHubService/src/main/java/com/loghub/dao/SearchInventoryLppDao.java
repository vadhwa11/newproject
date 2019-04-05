package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryLppDao {

	public ResponseModel getInventoryLppSearch(String partNo, String desc, String equipment, String ledgerNo);
	
}