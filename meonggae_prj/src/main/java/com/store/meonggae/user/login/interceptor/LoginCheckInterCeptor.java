//package com.store.meonggae.user.login.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class LoginCheckInterCeptor implements HandlerInterceptor {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		HttpSession session = request.getSession(false);
//		
//		if(session == null || session.getAttribute("user") == null) {
//			response.sendRedirect("index.do");
//			return false;
//		}
//		return true;
//	}
//}
