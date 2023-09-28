package com.web.oauth.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.web.oauth.base.model.BaseAuthRole;
import com.web.oauth.base.service.BaseCustomOAuth2userService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity//Ȱ��ȭ
@RequiredArgsConstructor
public class WebSecurityConfig{//ȯ�漳��
	
	@Autowired
	private final BaseCustomOAuth2userService baseCustomOAuth2userService;
	
	@Bean//Security
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		
		http.
			csrf().disable().headers().frameOptions().disable()
			.and()
			.authorizeRequests()
			.antMatchers("/","css/**","/images/**","/js/**","h2/**","h2-console/**").permitAll()
			.antMatchers("/api/v1/**").hasRole(BaseAuthRole.USER.name())
			.anyRequest().authenticated()
			.and()
			//.logout().logoutSuccessUrl("/") �Ʒ������� 1�ٷ�  
			.logout().logoutUrl("/logout").logoutSuccessUrl("/")
			.deleteCookies("JESSIONID").invalidateHttpSession(true)
			.and()
			.oauth2Login()
				.defaultSuccessUrl("/").userInfoEndpoint()
				.userService(baseCustomOAuth2userService);
		
		/*
		csrf().disable : CSRF = Cross Site Request Forgery 
		����Ʈ�� ���� ��û / �������� ����ڰ� �ǵ�ġ ���� ������û�� ������ �� 
		frameOptions().disable() : h2 db�� consoleȭ���� ����ϱ����� �ش� �ɼ� disable
		authorizeRequests : URL�� ���� ������ �����ϴ� �ɼ��� ������
			      authorizeRequests�� �����Ǿ�� antMatchers�� ��밡����
		antMatchers : ���� ���� ����� �����ϴ� �ɼ�(��ȣ�ȿ� ��û�� ���� ���)
		permitAll : ����� �ּҿ� ��ü ���� �������� ����
		hasRole : Ư�� �ּҸ� Ư���ο��Ը� ������ �ο�
		    /api/v1/ �ּҸ� ���� API�� USER ������ ���� ����� ����
		anyRequest : ���� �ּ� �̿� ������ URL�� ���� ���� ����(authenticated:�����Ȼ���ڿ��Ը� ���)
		logoutSuccessUrl("/") : �α׾ƿ� ������ / �ּҷ� �̵� 
		oauth2Login : OAuth2 �α��� ��ɿ�����  ���� ������ 
		userInfoEndpoint : OAuth2 �α��� ���� �� ����� ������ ������ ������ ����
		userService : �α��� ������ �ļ� ó���� UserService �������̽� ����ü ���
		�α��� �����ϸ� ����� �����͸� [baseCustomOAuth2UserService]���� �޾Ƽ� ó�� ��.
		*/
		
		return http.build();
	}
	

}
