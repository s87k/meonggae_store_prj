package com.store.meonggae.user.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.meonggae.product.domain.ProductDomain;
import com.store.meonggae.product.service.ProductAddService;
import com.store.meonggae.product.vo.ProductAddVO;
import com.store.meonggae.user.login.domain.LoginDomain;
import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
    
    @Autowired
    private ProductAddService productAddService;
    
    @GetMapping("/product_page/product_add.do")
    public String productAdd(Model model, HttpSession session) {
        // 사용자 정보를 세션에서 가져옴
        LoginDomain loginUser = (LoginDomain) session.getAttribute("user");
        int memNum = loginUser.getMemNum();
        System.out.println("유저 번호:"+memNum);
        
        if (loginUser != null) {
            List<ProductDomain> productList = productAddService.selectProductByUser(memNum);
            System.out.println(productList);
            model.addAttribute("productList", productList);
            model.addAttribute("user", loginUser);
            model.addAttribute("memNum", loginUser.getMemNum());
        }
        
        return "product_page/product_add";
    }
    
	/*
	 * @PostMapping("/product_page/product_add.do") public String
	 * insertProduct(@ModelAttribute ProductAddVO productAddVO, HttpSession session)
	 * { // 사용자 정보를 세션에서 가져옴 LoginDomain loginUser = (LoginDomain)
	 * session.getAttribute("loginUser");
	 * 
	 * if (loginUser != null) { productAddVO.setMem_num_sell(loginUser.getMemNum());
	 * // 판매자 ID 설정 productAddService.inserctProduct(productAddVO); }
	 * 
	 * return "redirect:/product_page/product_add.do"; }
	 * 
	 * @PostMapping("/product_page/product_select.do") public String
	 * updateProduct(@ModelAttribute ProductAddVO productAddVO, HttpSession session)
	 * { // 사용자 정보를 세션에서 가져옴 LoginDomain loginUser = (LoginDomain)
	 * session.getAttribute("loginUser");
	 * 
	 * if (loginUser != null) { productAddVO.setMem_num_sell(loginUser.getMemNum());
	 * // 판매자 ID 설정 productAddService.updateProudct(productAddVO); }
	 * 
	 * return "redirect:/product_page/product_add.do"; }
	 */
}
