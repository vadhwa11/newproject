package com.loghub.serviceImpl;
import com.loghub.dao.SearchInventoryLppDao;
import com.loghub.daoImpl.SearchInventoryLppDaoImpl;
import com.loghub.dto.ResponseModel;
import com.loghub.service.SearchInventoryLppService;


public class SearchInventoryLppServiceImpl implements SearchInventoryLppService{
		
		SearchInventoryLppDao searchDao =new SearchInventoryLppDaoImpl();

		public ResponseModel getInventoryLppSearch(String partNo, String desc, String equipment, String ledgerNo) {
			return searchDao.getInventoryLppSearch(partNo, desc, equipment,ledgerNo);
		}

		}

