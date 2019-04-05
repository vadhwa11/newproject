package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.SearchNacDao;
import com.icg.model.NacItemDTO;
@Service
public class SearchNacServiceImpl implements SearchNacService{

	@Autowired
	SearchNacDao searchNacDao;
	@Override
	public List<NacItemDTO> getNacDetails(String partNo, String depot, String fromDate, String toDate) {
		
		return searchNacDao.getNacDetails(partNo, depot, fromDate, toDate);
	}

}
