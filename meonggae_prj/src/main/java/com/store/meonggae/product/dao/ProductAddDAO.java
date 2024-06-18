
package com.store.meonggae.product.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.meonggae.dao.MybatisDAO;
import com.store.meonggae.product.domain.ProductDomain;
import com.store.meonggae.product.vo.ProductAddVO;
import com.store.meonggae.user.login.domain.LoginDomain;

@Component
public class ProductAddDAO {

	@Autowired
	private MybatisDAO mbDAO;

	public List<ProductDomain> selectProductByUser(int memNum)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectList("com.store.meonggae.product.selectProductByUser", memNum);
		}
	}// selectProductByUser

	/*
	 * public int inserctProduct(ProductAddVO padVO) { ProductDomain pd; try
	 * (SqlSession ss = mbDAO.getMyBatisHandler(false)) { return
	 * ss.insert("com.store.meonggae.product.inserctProduct"); } }// insertProduct
	 * 
	 * public int updateProudct(ProductAddVO padVO) { try (SqlSession ss =
	 * mbDAO.getMyBatisHandler(false)) { return
	 * ss.update("com.store.meonggae.product.updateProudct"); } } // updateProudct
	 */}
