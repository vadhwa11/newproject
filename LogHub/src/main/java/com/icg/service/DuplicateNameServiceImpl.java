package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.DuplicateNameDao;
import com.icg.model.Currency;

@Service
public class DuplicateNameServiceImpl implements DuplicateNameService {

	
	@Autowired
	DuplicateNameDao duplicateNameDao;
	
	@Override
	public List<String> DuplicateName(String currencyName) {
		
		return duplicateNameDao.DuplicateName(currencyName);
	}

}
