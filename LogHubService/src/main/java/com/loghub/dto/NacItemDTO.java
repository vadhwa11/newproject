package com.loghub.dto;

import java.util.List;

public class NacItemDTO {
	//private String sku;
	//private int quantity;
	private String demandNo;
	private String demandDate;
	private String depot;
	//private String uom;
	private String quantity;
	//private String transaction;
	
	//private String sPartNo;
	//private NacDTO nacDto;
	//private InventoryDTO inventoryDTO;
	//private LmsCodeUnit lmsCodeUnit;
	private String signalAdd;
	private String ledgerNo;
	private int nacNo;
	private String nacDate;
	private String description;
	private String partNo;
	private String equipment;
	
	
public String getSignalAdd() {
		return signalAdd;
	}
	public void setSignalAdd(String signalAdd) {
		this.signalAdd = signalAdd;
	}
	public String getLedgerNo() {
		return ledgerNo;
	}
	public void setLedgerNo(String ledgerNo) {
		this.ledgerNo = ledgerNo;
	}
	public int getNacNo() {
		return nacNo;
	}
	public void setNacNo(int nacNo) {
		this.nacNo = nacNo;
	}
	public String getNacDate() {
		return nacDate;
	}
	public void setNacDate(String nacDate) {
		this.nacDate = nacDate;
	}
	/*	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	*/
	
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
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
	/*public String getUom() {
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
	}*/
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
	/*public String getsPartNo() {
		return sPartNo;
	}
	public void setsPartNo(String sPartNo) {
		this.sPartNo = sPartNo;
	}*/
	/*public InventoryDTO getInventoryDTO() {
		return inventoryDTO;
	}
	public void setInventoryDTO(InventoryDTO inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}
	public LmsCodeUnit getLmsCodeUnit() {
		return lmsCodeUnit;
	}
	public void setLmsCodeUnit(LmsCodeUnit lmsCodeUnit) {
		this.lmsCodeUnit = lmsCodeUnit;
	}*/
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}

}
