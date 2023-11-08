package edu.pnu.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

	@GetMapping("/login")
	public void login() {

	}

	@GetMapping("/loginSuccess")
	public void loginSuccess() {

	}

	@GetMapping("/accessDenied")
	public void accessDenied() {

	}

	@GetMapping("/auth")
	public @ResponseBody String auth(@AuthenticationPrincipal User user) {
		return user.toString();
	}
}
