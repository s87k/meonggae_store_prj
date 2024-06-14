package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/product_page/product_add.do")
	public String productAdd() {
		
		return "product_page/product_add";
	}
	
	
	
}
