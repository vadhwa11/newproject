package com.icg.dao;

import java.util.List;

import com.icg.model.Inventory;

public interface InventoryDao {

	int addInventory(Inventory inventory);

	List<Inventory> viewInventory(String sku);

	int updateInventory(Inventory inventory);
	

	List<Inventory> searchInventoryStatus(String partNo, String desc, String depot, String sku, String equipment, String ledgerNo);
	
	List<Inventory> searchInventoryDetails(String partNo, String desc, String depot);
	
	List<Inventory> searchInventoryLpp(String partNo, String desc, String equipment, String ledgerNo);
	
	List<Inventory> advnacedSearchInventoryStatus(String advancePartNo, String advDescr, String partRadio);


}
