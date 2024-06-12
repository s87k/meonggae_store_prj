package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
public class MainController {

	@RequestMapping(value="/index.do",method= {GET,POST})
	public String main() {
		
		return "main_page/main_contents";
	}
	
	/*
	 * @GetMapping("/index.do") public String goToMain() {
	 * 
	 * return "main_page/main_contents"; }
	 */
	
	@GetMapping("/main_page/products_detail.do")
	public String productDetail() {
		
		return "main_page/products_detail";
	}
	@GetMapping("/login_page/login_page.do")
	public String login() {
		
		return "/login_page/login_page";
	}
	
	@GetMapping("/login_page/mem_join.do")
	public String join() {
		
		return "/login_page/mem_join";
	}
}
