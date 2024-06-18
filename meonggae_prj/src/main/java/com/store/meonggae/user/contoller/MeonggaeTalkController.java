package com.store.meonggae.user.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.store.meonggae.product.domain.ProductDomain;
import com.store.meonggae.user.login.domain.LoginDomain;

@Controller
public class MeonggaeTalkController {

	@GetMapping("/meongae_talk/talk_page.do")
	public String meongaeTalk(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		LoginDomain loginUser = (LoginDomain) session.getAttribute("user");

        if (loginUser != null) {
            model.addAttribute("user", loginUser);
		return "meongae_talk/talk_page";
	}else {
        redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다.");
        return "redirect:/index.do";
    }
	
	}
}
