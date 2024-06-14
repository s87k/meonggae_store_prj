package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.meonggae.product.domain.CategoryDomain;
import com.store.meonggae.product.service.CategoryService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/index.do",method= {GET,POST})
	public String main(Model model) {
		//전체보기 카테고리(대분류)
		List<CategoryDomain> parentCategory = categoryService.selectParentCategory();
		model.addAttribute("parentCategory", parentCategory);
		
		return "main_page/main_contents";
	}
	
//	@RequestMapping(value="/subCategory.do", method= {RequestMethod.GET}, produces = "application/json")
	@GetMapping("/subCategory.do")
	@ResponseBody
    public List<CategoryDomain> subCategory(@RequestParam("parentCategory") String parentCategory) {
		//전체보기 카테고리(소분류)
		System.out.println("부모 = "+parentCategory);
        List<CategoryDomain> subCategory = categoryService.selectSubCategory(parentCategory);
        System.out.println("subCategory = "+subCategory);
        return subCategory;
    }

	/*
	 * @GetMapping("/index.do") public String goToMain() {
	 * 
	 * return "main_page/main_contents"; }
	 */
	
	//검색페이지 이동
	@GetMapping("/main_page/search_contents.do")
	public String searchContents() {
		
		return "main_page/search_contents";
	}
	//상세페이지 이동
	@GetMapping("/main_page/products_detail.do")
	public String productDetail() {
		
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
