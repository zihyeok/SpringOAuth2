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
	public boolean supportsParameter(MethodParameter parameter) {// parameter = �α��εǾ��ִ� ��������
		
		boolean isLoginUserAnnotation =
				parameter.getParameterAnnotation(LoginUser.class)!=null;//���� �ְų�
		
		boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
		//parameter �α��ε� ���������� sessionuser.class�� ������ ture 
		
		return isLoginUserAnnotation && isUserClass;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, 
			WebDataBinderFactory binderFactory) throws Exception {//���ο��� �����°��̶� �Ⱥ���
		
		return httpSession.getAttribute("user");//������ ���ƾ���
	}
	
	
	
}
