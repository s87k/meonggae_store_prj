package com.store.meonggae.mgr.manager.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import com.store.meonggae.mgr.dao.MgrManagerDAO;
import com.store.meonggae.mgr.manager.domain.MgrManagerDomain;
import com.store.meonggae.mgr.manager.vo.ManagerSearchVO;

@Service
public class MgrManagerService {
	
	@Autowired
	private MgrManagerDAO mmDAO;
	
	// 검색된 관리자 수
	public int getTotalCount(ManagerSearchVO sVO) {
		int totalCount = 0;
		
		try {
			totalCount = mmDAO.selectOneManagerCount(sVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		
		return totalCount;
	} // totalCount
	
	// 한 화면에 보여줄 게시물의 수
	public int getPageScale() {
		int pageScale = 10;
		return pageScale;
	} // pageScale
	
	// 총 페이지수
	public int getTotalPage(int totalCount, int pageScale) {
		return (int)Math.ceil((double)totalCount / pageScale);
	} // totalPage
	
	// 현재 페이지
	public int getCurrentPage(ManagerSearchVO sVO) {
		int currentPage = 1;
		
		String tempPage = sVO.getCurrentPage();
		if(tempPage != null) {
			try {
				currentPage = Integer.parseInt(tempPage); 
			} catch (NumberFormatException nfe) {
			} // end catch
		} // end if
		return currentPage;
	} // getCurrentPage
	
	// 게시물의 시작 번호
	public int getStartNum(int currentPage, int pageScale) {
		int startNum = (currentPage - 1) * pageScale + 1;
		return startNum;
	} // getStartNum
	
	public int getEndNum(int startNum, int pageScale) {
		int endNum = startNum + pageScale - 1;
		return endNum;
	} // getEndNum
	
	// 검색된 리스트 조회
	public List<MgrManagerDomain> searchListManager(ManagerSearchVO sVO) {
		List<MgrManagerDomain> list = null;
		
		try {
			list = mmDAO.selectListManager(sVO);
			
			MgrManagerDomain mmDomain = null;
			
			String key = "test1234";
			String salt = "123456";
			TextEncryptor te = Encryptors.text(key, salt);
			
			for(int i = 0; i < list.size(); i++) {
				mmDomain = list.get(i);
				mmDomain.setName(te.decrypt(mmDomain.getName()));
			} // end for
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		
		return list;
	} // searchManagerList
	
	public MgrManagerDomain searchOneManager (String managerId) {
		MgrManagerDomain mmDomain = null;
		
		try {
			mmDomain = mmDAO.selectOneManager(managerId);
			
			String key = "test1234";
			String salt = "123456";
			TextEncryptor te = Encryptors.text(key, salt);
			
			mmDomain.setName(te.decrypt(mmDomain.getName()));
			mmDomain.setBirth(te.decrypt(mmDomain.getBirth()));
			mmDomain.setTel(te.decrypt(mmDomain.getTel()));
			mmDomain.setAddr1(te.decrypt(mmDomain.getAddr1()));
			mmDomain.setAddr2(te.decrypt(mmDomain.getAddr2()));
			if(mmDomain.getParentManagerName() != null && mmDomain.getParentManagerName() != "") {
				mmDomain.setParentManagerName(te.decrypt(mmDomain.getParentManagerName()));
			} // end if
			mmDomain.setPermission(te.decrypt(mmDomain.getPermission()));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		
		return mmDomain;
	} // searchOneManager
} // class
