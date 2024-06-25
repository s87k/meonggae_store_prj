package com.store.meonggae.mgr.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.store.meonggae.mgr.common.service.BoardUtilService;
import com.store.meonggae.mgr.manager.domain.MgrManagerDomain;
import com.store.meonggae.mgr.manager.service.MgrManagerService;
import com.store.meonggae.mgr.manager.vo.ManagerSearchVO;

@Controller
public class MgrManagerController {
	
	@Autowired
	private MgrManagerService mmService;
	@Autowired
	private BoardUtilService boardUtilService;
	
	@GetMapping("/mgr/manager/mgr_manager_list_frm.do")
	public String searchListManager(ManagerSearchVO sVO, Model model) {
		
		List<MgrManagerDomain> list = null;
		
		// 총 레코드의 수 얻기
		int totalCount = mmService.getTotalCount(sVO);
		// 한 화면에 보여줄 게시물의 수
		int pageScale = mmService.getPageScale();
		// 총 페이지수
		int totalPage = mmService.getTotalPage(totalCount, pageScale);
		// 현재 페이지
		int currentPage = mmService.getCurrentPage(sVO);
		
		// 게시물의 시작 번호
		int startNum = mmService.getStartNum(currentPage, pageScale);
		// 게시물의 끝번호
		int endNum = mmService.getEndNum(startNum, pageScale);
		
		sVO.setStartNum(startNum);
		sVO.setEndNum(endNum);
				
		list = mmService.searchListManager(sVO);
		
		String param = "";
		if(sVO.getKeyword() != null) {
			param = "&field=" + sVO.getField() + "&keyword=" + sVO.getKeyword();
		} // end if
		String pageNation = boardUtilService.pageNation("mgr/manager/mgr_manager_list_frm.do", param, totalPage, currentPage);
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageNation", pageNation);
		model.addAttribute("list", list);
		
		return "mgr/manager/mgr_manager_list_frm";
	} // searchManagerList
	
	@GetMapping("/mgr/manager/mgr_manager_detail_frm.do")
	public String searchOneManager(String managerId, Model model) {
		MgrManagerDomain mmDomain = mmService.searchOneManager(managerId);
		model.addAttribute("mgrManagerDomain", mmDomain);
		
		return "/mgr/manager/mgr_manager_detail_frm";
	} // searchOneManager
	
	@GetMapping("/mgr/manager/mgr_manager_add_frm.do")
	public String searchOneManager() {
		
		return "/mgr/manager/mgr_manager_add_frm";
	} // searchOneManager
	
} // class
