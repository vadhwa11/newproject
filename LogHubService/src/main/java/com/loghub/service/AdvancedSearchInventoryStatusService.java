package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface AdvancedSearchInventoryStatusService {
	
	public ResponseModel getAdvancedInventoryStatusSearch(String advancePartNo, String advDescr, String partRadio);

}
