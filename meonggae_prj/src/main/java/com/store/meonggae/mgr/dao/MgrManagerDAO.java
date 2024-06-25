package com.store.meonggae.mgr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import com.store.meonggae.mgr.manager.domain.MgrManagerDomain;
import com.store.meonggae.mgr.manager.vo.ManagerSearchVO;
import com.store.meonggae.mgr.manager.vo.MgrManagerVO;

@Component
public class MgrManagerDAO {
	
	@Autowired(required = false)
	private MyBatisDAO mbDAO;
	
	// 검색된 관리자의 수
	public int selectOneManagerCount( ManagerSearchVO sVO){
		
		int totalCnt = 0;
		
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		totalCnt = ss.selectOne("com.store.meonggae.mgr.manager.selectOneListCnt", sVO);
		
		return totalCnt;
	} // selectManagerCount
	
	// 검색된 관리자 리스트
	public List<MgrManagerDomain> selectListManager( ManagerSearchVO sVO ){
		
		List<MgrManagerDomain> list = null;
		
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("com.store.meonggae.mgr.manager.selectListManager", sVO);

		return list;
	} // selectListManager
	
	public MgrManagerDomain selectOneManager(String managerId) {
		MgrManagerDomain mmDomain = null;
		
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		mmDomain = ss.selectOne("com.store.meonggae.mgr.manager.selectOneManager", managerId);

		return mmDomain;
	} // selectOneManager
	
	public void insertManager(MgrManagerVO mmVO) {
		
	} // insertManager
} // class
