package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryService {
	ResponseModel getInventoryDetails(String sku);
}
