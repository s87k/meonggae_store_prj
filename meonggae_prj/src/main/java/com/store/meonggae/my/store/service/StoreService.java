package com.store.meonggae.my.store.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.meonggae.my.store.dao.StoreDAO;
import com.store.meonggae.my.store.domain.StoreMainDomain;

@Service
public class StoreService {
	
	@Autowired
	private StoreDAO sDAO;
	
	public List<StoreMainDomain> searchSalesList(String nick){
		List<StoreMainDomain> list = null;
		
		try {
		list = sDAO.selectSalesList(nick);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//searchSalesList
}
