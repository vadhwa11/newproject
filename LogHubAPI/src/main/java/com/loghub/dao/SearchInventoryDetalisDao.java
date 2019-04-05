package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryDetalisDao {
	public ResponseModel getInventoryDetalisSearch(String partNo, String desc, String depot);
}
