package com.ledmega.web1.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 *  main page.
	 *  
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		
		System.out.println("ÀÏ·Î¿È?");
		
		return "/main/index";
	}
}
