package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface SearchInventoryDao {

	ResponseModel getInventoryDetails(String sku);
}
