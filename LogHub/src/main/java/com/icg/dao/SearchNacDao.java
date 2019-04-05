package com.icg.dao;

import java.util.List;

import com.icg.model.NacItemDTO;

public interface SearchNacDao {
	List<NacItemDTO> getNacDetails(String partNo, String depot, String fromDate, String toDate);

}
