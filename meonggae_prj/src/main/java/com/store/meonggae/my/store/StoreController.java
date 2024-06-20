package com.store.meonggae.my.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String storeMain(@RequestParam("nick") String nick, Model model) {
		
		List<StoreMainDomain> list = ss.searchSalesList(nick);
		model.addAttribute("listSales", list);
		
		String profile = ss.searchProfile(nick);
		model.addAttribute("profile", profile);
		
		return "My/store/store_frm";
	}
	
	/**
	 * 내 상점 : 리뷰
	 * @return
	 */
	@GetMapping("/store_review_frm.do")
	public String storeReview(@RequestParam("nick") String nick, Model model) {
		
		String profile = ss.searchProfile(nick);
		model.addAttribute("profile", profile);
		
		return "My/store/review_frm";
	}
	
}//class
