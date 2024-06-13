package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemJoinController {

	@GetMapping("/join_page/id_dup.do")
	public String idDup() {
		return "join_page/id_dup";
	}
	@GetMapping("/join_page/nick_dup.do")
	public String nickDup() {
		return "join_page/nick_dup";
	}
}
