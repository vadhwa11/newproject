package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface NacDao {
	public ResponseModel getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
