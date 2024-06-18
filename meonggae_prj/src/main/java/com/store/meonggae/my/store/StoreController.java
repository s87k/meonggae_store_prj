package com.store.meonggae.my.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.meonggae.my.store.domain.StoreMainDomain;
import com.store.meonggae.my.store.service.StoreService;

@RequestMapping("/My/store")
@Controller
public class StoreController {
	@Autowired(required = false)
	private StoreService ss;
	
	/**
	 * 내 상점 : 메인
	 * @return
	 */
	@GetMapping("/store_frm.do")
	public String storeMain(String nick, Model model) {
		
		List<StoreMainDomain> list = ss.searchSalesList(nick);
		model.addAttribute("listSales", list);
		System.out.println(list);
		
		return "My/store/store_frm";
	}
	
	/**
	 * 내 상점 : 리뷰
	 * @return
	 */
	@GetMapping("/store_review_frm.do")
	public String storeReview() {
		return "My/store/store_review_frm";
	}
	
}//class
