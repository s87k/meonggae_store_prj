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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/index.do",method= {GET,POST})
	public String main(Model model) {
		return "main_page/main_contents";
	}
	
	//전체보기 카테고리(대분류)
	//@ResponseBody json형식으로 변환하여 클라이언트에게 전달.
	@ResponseBody
	@RequestMapping(value="/parentCategory.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public String parentCategory() {
		List<CategoryDomain> parentCategory = categoryService.selectParentCategory();
		
		JSONArray jsonArr = new JSONArray();
		for(CategoryDomain category : parentCategory) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("categoryNum", category.getCategoryNum());
			jsonObj.put("name", category.getName());
			jsonObj.put("parentCategoryNum", category.getParentCategoryNum());
			jsonArr.add(jsonObj);
		}//for
		return jsonArr.toJSONString();
	}//parentCategory
	
	//전체보기 카테고리(소분류)
	@ResponseBody
	@RequestMapping(value="/subCategory.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
    public String subCategory(@RequestParam("Category") String parentCategory) {
		System.out.println("부모 = "+parentCategory);
        List<CategoryDomain> subCategory = categoryService.selectSubCategory(parentCategory);
        System.out.println("subCategory = "+subCategory);
        
        JSONArray jsonArr = new JSONArray();
		for(CategoryDomain category : subCategory) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("categoryNum", category.getCategoryNum());
			jsonObj.put("name", category.getName());
			jsonObj.put("parentCategoryNum", category.getParentCategoryNum());
			jsonArr.add(jsonObj);
		}//for
        
        return jsonArr.toJSONString();
    }//subCategory

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
