package com.store.meonggae.my.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/My/mypage")
@Controller
public class DibsController {
	
	/**
	 * 마이페이지 : 찜목록
	 * @return
	 */
	@GetMapping("/dibs/dibsGoods_frm.do")
	public String dibs() {
		return "/My/mypage/dibs/dibsGoods_frm";
	}
	
}//class
