package com.web.oauth.base.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.oauth.base.dto.SessionUser;
import com.web.oauth.base.service.LoginUser;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor//생성자를 주입하려고
public class BaseAuthController {
	
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model,@LoginUser SessionUser user) {
	//@LoginUser SessionUser user 밑에있는 세션을 대신해줌
		
		//SessionUser user = 
				//(SessionUser)httpSession.getAttribute("user");
		
		if (user!=null) {
			
			model.addAttribute("email",user.getEmail());
			model.addAttribute("name",user.getName());
			model.addAttribute("picture",user.getPicture());
			
		}
	
		return "index";
	}
	
	
}
