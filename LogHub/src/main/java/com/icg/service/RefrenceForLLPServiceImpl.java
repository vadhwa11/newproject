package com.icg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.RefrenceForLLPDao;
import com.icg.model.RefrenceForLLP;

@Service
public class RefrenceForLLPServiceImpl implements RefrenceForLLPService{

	@Autowired
	RefrenceForLLPDao refrenceForLLPDao;
	@Override
	public List<RefrenceForLLP> refrenceForLPP(String sku) {
		
		return refrenceForLLPDao.refrenceForLPP(sku);
	}

}
