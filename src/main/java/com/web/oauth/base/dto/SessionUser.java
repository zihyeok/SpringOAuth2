package com.web.oauth.base.dto;

import java.io.Serializable;
import com.web.oauth.base.model.BaseAuthUser;
import lombok.Getter;

//인증된 사용자 정보를 DTO에 넣고 세션에 저장
@Getter
public class SessionUser implements Serializable{//직렬화
	
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(BaseAuthUser user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
	
	
}
