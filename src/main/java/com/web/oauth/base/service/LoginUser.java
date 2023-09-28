package com.web.oauth.base.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션 만드는 방법 (사용자정의)
//@LoginUser 어노테이션 생성

//@Target(ElementType.PARAMETER)
//어노테이션이 생성될수있는 위치를 지정
//parameter : 메소드의 파라미터로 선언된 객체에서 사용
//@interface : 어노테이션 클래스로 지정

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
