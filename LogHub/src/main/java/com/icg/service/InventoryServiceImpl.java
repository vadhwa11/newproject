package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.InventoryDao;
import com.icg.model.Inventory;


@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;
	
	@Override
	public int addInventory(Inventory inventory) {
		
		return inventoryDao.addInventory(inventory);
	}

	@Override
	public List<Inventory> viewInventory(String sku) {
		
		return inventoryDao.viewInventory(sku);
	}

	@Override
	public int updateInventory(Inventory inventory) {
		
		return inventoryDao.updateInventory(inventory);
	}

	@Override
	public List<Inventory> searchInventoryStatus(String partNo, String desc, String depot,String sku, String equipment,String ledgerNo) {
		return inventoryDao.searchInventoryStatus(partNo, desc, depot, sku, equipment,ledgerNo);
	}
	
	
	@Override
	public List<Inventory> searchInventoryDetails(String partNo, String desc, String depot) {
		return inventoryDao.searchInventoryDetails(partNo, desc, depot);
	}
	
	@Override
	public List<Inventory> searchInventoryLpp(String partNo, String desc, String equipment, String ledgerNo) {
		return inventoryDao.searchInventoryLpp(partNo, desc, equipment, ledgerNo);
	}

	@Override
	public List<Inventory> advnacedSearchInventoryStatus(String advancePartNo, String advDescr, String partRadio) {
		
		return inventoryDao.advnacedSearchInventoryStatus(advancePartNo, advDescr, partRadio);
	}
	

}


