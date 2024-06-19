package com.store.meonggae.user.contoller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.meonggae.product.domain.SearchProductDetailDomain;
import com.store.meonggae.product.domain.SearchProductDomain;
import com.store.meonggae.product.service.SearchProductService;


@Controller
public class MainController {
	
	@Autowired
	private SearchProductService SearchProductService;

	@RequestMapping(value="/index.do",method= {GET,POST})
	public String main(Model model) {
		List<SearchProductDomain> list = SearchProductService.selectAllProduct();
		model.addAttribute("list", list);
		return "main_page/main_contents";
	}
	
	/*
	 * @GetMapping("/index.do") public String goToMain() {
	 * 
	 * return "main_page/main_contents"; }
	 */
	
	//검색페이지 이동
	@GetMapping("/main_page/search_contents.do")
	public String searchContents(@RequestParam(required = false) String keyword, @RequestParam(required = false) String cate, Model model) {
		if(keyword != null && cate == null) {
			List<SearchProductDomain> list = SearchProductService.selectPrdKey(keyword);
			Map<String, Long> cateCnt = SearchProductService.cateCnt(list);
			model.addAttribute("list",list);
			model.addAttribute("cateCnt",cateCnt);
			model.addAttribute("keyword",keyword);
		}else if(keyword != null && cate != null) {
			System.out.println(keyword + " / " + cate);
		}
		
		return "main_page/search_contents";
	}
	//상세페이지 이동
	@GetMapping("/main_page/products_detail.do")
	public String productDetail(@RequestParam(required = false) String goodsNum, Model model) {
		SearchProductDetailDomain spd = SearchProductService.selectPrdDetail(goodsNum);
		model.addAttribute("spd", spd);
		
		return "main_page/products_detail";
	}
	//로그인
	@GetMapping("/login_page/login_page.do")
	public String login() {
		
		return "/login_page/login_page";
	}
	//회원가입
	@GetMapping("/join_page/mem_join.do")
	public String join() {
		
		return "/join_page/mem_join";
	}
}
