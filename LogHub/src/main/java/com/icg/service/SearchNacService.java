package com.icg.service;

import java.util.List;

import com.icg.model.NacItemDTO;


public interface SearchNacService {
	
	List<NacItemDTO> getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
