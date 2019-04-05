package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchLastPurchasePriceDao {
	public ResponseModel getLastPurchasePrice(String partNo);

}
