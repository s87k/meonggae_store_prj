package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeonggaeTalkController {

	@GetMapping("/meongae_talk/talk_page.do")
	public String meongaeTalk() {
		
		return "meongae_talk/talk_page";
	}
	
	
}
