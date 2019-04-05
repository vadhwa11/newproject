package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryStatusService {
	public ResponseModel getInventoryStatusSearch(String partNo, String secondPartNo, String desc, String depot, String equipment);
	}
