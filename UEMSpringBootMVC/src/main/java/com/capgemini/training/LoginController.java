package com.capgemini.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@GetMapping("/")
	public String loginPage() {
		return "login.jsp";
	}
	
	@PostMapping("/home")
	public String validate(String user , String password) {
		System.out.println(user);
		System.out.println(password);
		
		return "home.jsp";
	}
	
	
	@GetMapping("/forget")
	public String forgetPassword() {
		return "forget.jsp";
	}
	
	
	
}
