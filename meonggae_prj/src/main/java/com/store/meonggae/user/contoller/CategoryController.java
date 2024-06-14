package com.store.meonggae.user.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.meonggae.product.domain.CategoryDomain;
import com.store.meonggae.product.service.CategoryService;

@Controller
public class CategoryController {

	/*
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/index.do")
	public String getParentCategory(Model model) {
		List<CategoryDomain> parentCategory = categoryService.selectParentCategory();
		model.addAttribute("parentCategory", parentCategory);
		return "main_page/main_contents";
	}
	
	@GetMapping("/categories/{parentCategory}/subcategories")
	@ResponseBody
	public List<CategoryDomain> getSubCategory(@PathVariable("parentCategory") String parentCategory, Model model){
		return categoryService.selectSubCategory(parentCategory);
	}
	*/
	
	
	
}
