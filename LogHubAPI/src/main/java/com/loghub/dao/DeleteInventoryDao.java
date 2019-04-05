package com.loghub.dao;

import com.loghub.dto.ResponseModel;

public interface DeleteInventoryDao {

	ResponseModel deleteInventoryDetails(String sku);

}
