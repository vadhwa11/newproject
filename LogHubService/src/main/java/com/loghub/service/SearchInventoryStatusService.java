package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryStatusService {
	
	public ResponseModel getInventoryStatusSearch(String partNo, String desc, String depot,String sku, String equipment,String ledgerNo, String advancePartNo);
	}
