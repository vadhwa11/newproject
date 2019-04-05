package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryLppService {
	public ResponseModel getInventoryLppSearch(String partNo, String desc, String equipment, String ledgerNo);
	}