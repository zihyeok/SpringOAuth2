package com.web.oauth.base.service;

import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.web.oauth.base.dto.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver{

	private final HttpSession httpSession;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {// parameter = 로그인되어있는 유저정보
		
		boolean isLoginUserAnnotation =
				parameter.getParameterAnnotation(LoginUser.class)!=null;//값이 있거나
		
		boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
		//parameter 로그인된 유저정보와 sessionuser.class가 같으면 ture 
		
		return isLoginUserAnnotation && isUserClass;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, 
			WebDataBinderFactory binderFactory) throws Exception {//내부에서 가져온값이라 안보임
		
		return httpSession.getAttribute("user");//변수가 같아야함
	}
	
	
	
}
