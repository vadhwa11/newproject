package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchLastPurchasePriceService {
	public ResponseModel getLastPurchasePrice(String partNo);

}
