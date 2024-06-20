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
import com.store.meonggae.product.vo.SearchProductVO;


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
	public String searchContents(
			@RequestParam(name = "kw", required = false) String kw, 
			@RequestParam(name = "cn", required = false) String cn,
			@RequestParam(name = "isP", required = false) String isP, 
			Model model) {
		List<SearchProductDomain> list = null;
		if(kw != null && cn == null && isP == null) {
			//키워드만 있는 경우
			list = SearchProductService.selectPrdKey(kw);
		}else if(kw != null && cn != null ) {
			//키워드 & 카테고리 둘다 있는 경우
			SearchProductVO spVo = new SearchProductVO(kw, cn);
			list = SearchProductService.selectPrdKeyCate(spVo);
		}else if(kw == null && cn != null && isP != null) {
			//카테고리만 있는 경우
			if("T".equals(isP.trim())) {
				//부모 카테고리인 경우
				list = SearchProductService.selectPrdCateP(cn);
			}else if ("F".equals(isP.trim())) {
				//자식 카테고리인 경우
				list = SearchProductService.selectPrdCate(cn);
				
			}
		}
		
		Map<String, Long> cateCnt = SearchProductService.cateCnt(list);
		model.addAttribute("list",list);//조회 결과 리스트
		model.addAttribute("cateCnt",cateCnt);//조회된 상품들의 카테고리 카운팅
		model.addAttribute("keyword",kw);//검색된 키워드 검색창에 유지
		if(cn != null) {
			String categoryName = SearchProductService.selectCategoryName(cn);
			model.addAttribute("categoryName",categoryName);//검색된 키워드 검색창에 유지
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
