package com.store.meonggae.my.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/My/store")
@Controller
public class StoreController {
	
	/**
	 * 내 상점 : 메인
	 * @return
	 */
	@GetMapping("/store_frm.do")
	public String storeMain() {
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
