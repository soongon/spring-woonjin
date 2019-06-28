package com.woongjin.springsi.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.woongjin.springsi.annotation.TokenRequired;
import com.woongjin.springsi.service.SecurityService;

@Aspect
@Component
public class AuthenticationAspect {
	
	@Autowired
	private SecurityService securityService;
	
	@Before("@annotation(tokenRequired)")
	public void authenticateWithToken(TokenRequired tokenRequired) {
		// 토큰을 헤더에서 가져옴
		// 토큰의 유효성을 체크..
		// 토큰의 subject(사용자아이디)를 확인해서 인증을 해줄것인지 결정 
		// 유효한 토큰이 아니거나 유효한 사용자가 아니면 예외를 발생시킴..
		
		ServletRequestAttributes reqAttributes = 
	               (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request = reqAttributes.getRequest();    
	    
	    // checks for token in request header
	    String tokenInHeader = request.getHeader("token"); 
	    
	    String userid = securityService.parseToken(tokenInHeader);
	}

}
