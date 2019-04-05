package com.loghub.service;

import com.loghub.dto.ResponseModel;

public interface SearchNacService {
	
	ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
