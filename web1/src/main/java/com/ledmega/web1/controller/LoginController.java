package com.ledmega.web1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static final Integer cookieExpire = 60 * 60 * 24 * 30; // 1 month
	
	
	/**
	 *  main page.
	 *  
	 */
	@RequestMapping(value = "memberLogin")
	public String memberLogin(HttpServletRequest request, ModelMap modelMap) {
		System.out.println("일로옴???????????????????%%%%%%");
		//String userid = getCookie("sid", request);
		
		//modelMap.addAttribute("userid", userid);
		
		
		return "member/memberLogin";
	}
	
	/*
	 * 쿠키 가져오기
	 * 
	 */
	public static String getCookie(String cid, HttpServletRequest request) {
		String ret = "";
		if(request == null) {
			return ret;
		}
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			return ret;
		}
		
		for(Cookie ck : cookies) {
			if(ck.getName().equals(cid)) {
				ret = ck.getValue();
				
				ck.setMaxAge(cookieExpire);
				break;
			}
		}
		return ret;
	}
}
