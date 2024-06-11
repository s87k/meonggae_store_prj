package com.store.meonggae.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MgrLoginController {
	
	@GetMapping("/mgr/login/mgr_login_frm.do")
	public String mgrLoginFrm() {
		
//		return "mgr/login/mgr_login_frm";
		return "mgr/dashboard/mgr_dashboard_frm";
	} // mgrLoginFrm
} // class
