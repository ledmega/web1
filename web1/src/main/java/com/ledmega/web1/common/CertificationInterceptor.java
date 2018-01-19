package com.ledmega.web1.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CertificationInterceptor implements HandlerInterceptor {

	static final Logger LOGGER = LoggerFactory.getLogger(CertificationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		
		HttpSession session = request.getSession();
		try {
			if(session == null || session.getAttribute("userno") == null) {
				response.sendRedirect("memberLogin");
				return false;
			}else {
				//session.setMaxInactiveInterval(30*60);
				return true;
			}
		} catch ( IOException ex) {
			LOGGER.error("LoginIntercepter");
		}
		
		return true;
		//UserVO loginVO = (UserVO)session.getAttribute("loginUser");
		
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, 
			ModelAndView mv) throws Exception  {
    }
    
	@Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, 
    		Object handler, Exception ex) throws Exception{
    }
	
}
