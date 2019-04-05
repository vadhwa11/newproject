package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface NacService {
	public ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
