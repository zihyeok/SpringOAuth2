package com.web.oauth.base.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//������̼� ����� ��� (���������)
//@LoginUser ������̼� ����

//@Target(ElementType.PARAMETER)
//������̼��� �����ɼ��ִ� ��ġ�� ����
//parameter : �޼ҵ��� �Ķ���ͷ� ����� ��ü���� ���
//@interface : ������̼� Ŭ������ ����

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
