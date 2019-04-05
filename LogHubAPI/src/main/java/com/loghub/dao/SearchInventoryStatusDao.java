package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryStatusDao {

	public ResponseModel getInventoryStatusSearch(String partNo, String secondPartNo, String desc, String depot, String equipment);
	
}