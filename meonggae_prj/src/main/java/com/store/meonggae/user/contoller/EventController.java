package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

	@GetMapping("/event_page/event_main.do")
	public String event() {
		return "event_page/event_main";
	}
	
	@GetMapping("/event_page/event_handler.do")
	public String eventHandler() {
		return "/event_page/event_handler";
	}
	
	@GetMapping("/event_page/event_detail.do")
	public String eventDetail() {
		return "/event_page/event_detail";
	}

}
