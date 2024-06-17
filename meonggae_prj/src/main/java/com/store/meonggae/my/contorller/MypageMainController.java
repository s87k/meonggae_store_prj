package com.store.meonggae.my.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/My/mypage")
@Controller
public class MypageMainController {
	
	/**
	 * 마이페이지 : 메인
	 * @return
	 */
	@GetMapping("/main/myPageMain_frm.do")
	public String mypageMain() {
		return "/My/mypage/main/myPageMain_frm";
	}
	
}//class
