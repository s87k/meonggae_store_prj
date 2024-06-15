package com.store.meonggae.my.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/My/mypage")
@Controller
public class SalesListController {
	
	/**
	 * 마이페이지 : 거래내역_판매중
	 * @return
	 */
	@GetMapping("/sales_list/salesDetails_frm.do")
	public String salesDetailSales() {
		return "/My/mypage/sales_list/salesDetails_frm";
	}
	
	/**
	 * 마이페이지 : 거래내역_판매완료
	 * @return
	 */
	@GetMapping("/sales_list/soldDetails_frm.do")
	public String salesDetailSold() {
		return "/My/mypage/sales_list/soldDetails_frm";
	}
	
	/**
	 * 마이페이지 : 거래내역_구매완료
	 * @return
	 */
	@GetMapping("/sales_list/boughtDetails_frm.do")
	public String salesDetailBought() {
		return "/My/mypage/sales_list/boughtDetails_frm";
	}
	
}//class
