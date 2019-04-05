package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryDetalisService {
	public ResponseModel getInventoryDetailsSearch(String partNo, String desc, String depot);
}
