package com.loghub.dto;

import java.util.List;

public class NacItemDTO {
	private String sku;
	private int quantity;
	private String demandNo;
	private String demandDate;
	private String equipment;
	private String uom;
	private int qty;
	private String transaction;
	private String description;
	private String partNo;
	private String sPartNo;
	private NacDTO nacDto; 
	private InventoryDTO inventoryDTO;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDemandNo() {
		return demandNo;
	}
	public void setDemandNo(String demandNo) {
		this.demandNo = demandNo;
	}
	public String getDemandDate() {
		return demandDate;
	}
	public void setDemandDate(String demandDate) {
		this.demandDate = demandDate;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public NacDTO getNacDto() {
		return nacDto;
	}
	public void setNacDto(NacDTO nacDto) {
		this.nacDto = nacDto;
	}
	
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getsPartNo() {
		return sPartNo;
	}
	public void setsPartNo(String sPartNo) {
		this.sPartNo = sPartNo;
	}
	public InventoryDTO getInventoryDTO() {
		return inventoryDTO;
	}
	public void setInventoryDTO(InventoryDTO inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}
	

}
