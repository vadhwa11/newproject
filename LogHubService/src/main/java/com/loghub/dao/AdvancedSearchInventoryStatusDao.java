package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface AdvancedSearchInventoryStatusDao {
	
	public ResponseModel getAdvancedInventoryStatusSearch(String advancePartNo, String advDescr, String partRadio);
}
