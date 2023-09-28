package com.web.oauth.base.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.oauth.base.model.BaseAuthUser;

public interface BaseAuthUserRepository 
	extends JpaRepository<BaseAuthUser, Long>{

	//email을 통해 이미 생성된 사용자인지
	//처음 가입하는 사용자인지 확인
	Optional<BaseAuthUser> findByEmail(String email);
	
	
	
}
