package com.store.meonggae.user.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.store.meonggae.product.domain.ProductDomain;
import com.store.meonggae.product.service.ProductAddService;
import com.store.meonggae.user.login.domain.LoginDomain;
import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
    
    @Autowired
    private ProductAddService productAddService;
    
    @GetMapping("/product_page/product_add.do")
    public String productAdd(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // 사용자 정보를 세션에서 가져옴
        LoginDomain loginUser = (LoginDomain) session.getAttribute("user");

        if (loginUser != null) {
            int memNum = loginUser.getMemNum();
            List<ProductDomain> productList = productAddService.selectProductByUser(memNum);
            System.out.println(productList);
            model.addAttribute("productList", productList);
            model.addAttribute("user", loginUser);
            model.addAttribute("memNum", loginUser.getMemNum());
            return "product_page/product_add";
        } else {
            redirectAttributes.addFlashAttribute("message", "로그인이 필요한 서비스 입니다.");
            return "redirect:/index.do";
        }
    }
    
	/*
	 * @PostMapping("/product_page/product_add.do") public String
	 * handleProductAdd(@RequestParam("productName") String productName,
	 * 
	 * @RequestParam("productPrice") String productPrice,
	 * 
	 * @RequestParam("productDescription") String productDescription, HttpSession
	 * session, RedirectAttributes redirectAttributes) { // 사용자 정보를 세션에서 가져옴
	 * LoginDomain loginUser = (LoginDomain) session.getAttribute("user");
	 * 
	 * if (loginUser != null) { // 상품 등록 로직 수행 ProductDomain product = new
	 * ProductDomain(); product.setProductName(productName);
	 * product.setProductPrice(productPrice);
	 * product.setProductDescription(productDescription);
	 * product.setUserMemNum(loginUser.getMemNum());
	 * productAddService.addProduct(product);
	 * 
	 * return "redirect:/product_page/product_list.do"; } else {
	 * redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다."); return
	 * "redirect:/index.do"; } }
	 */
}
