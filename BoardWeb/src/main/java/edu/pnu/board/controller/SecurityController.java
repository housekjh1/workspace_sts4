package edu.pnu.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	
	@GetMapping("/system/login")
	public void login() {}
	
	@GetMapping("/system/accessDenied")
	public void accessDenied() {}
	
	@GetMapping("/system/logout")
	public void logout() {}
	
	@GetMapping("/system/logout1")
	public void logout1() {}
	
	@GetMapping("/admin/adminPage")
	public void admin() {}
	
	@GetMapping("/auth")
	public @ResponseBody String auth(@AuthenticationPrincipal OAuth2User user) {
		if (user == null) {
			return "user is Null";
		}
		return user.toString();
	}
	
	@GetMapping("/oauth")
	public @ResponseBody String oauth(@AuthenticationPrincipal OAuth2User user) {
		if (user == null) return "OAuth2:null";
		System.out.println("attributes:" + user.getAttributes());
		return "OAuth2:" + user;
	}
}