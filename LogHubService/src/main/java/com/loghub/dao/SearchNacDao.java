package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchNacDao {
	
	ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
