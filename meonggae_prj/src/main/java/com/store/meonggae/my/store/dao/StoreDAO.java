package com.store.meonggae.my.store.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.meonggae.dao.MybatisDAO;
import com.store.meonggae.my.store.domain.StoreMainDomain;

@Component
public class StoreDAO {
	
	@Autowired
	private MybatisDAO mbDAO;
	
	public List<StoreMainDomain> selectSalesList(String nick) throws PersistenceException{
		List<StoreMainDomain> list = null;
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("com.store.meonggae.store.storeSalesList", nick);
		mbDAO.CloseHandler(ss);
		
		return list;
	}//selectSalesList
	
}//class
