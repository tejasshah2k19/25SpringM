package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	
	//url->method 
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";//Jsp name 
	}
	

	@PostMapping("saveuser")
	public String saveUser(@Validated UserBean user,BindingResult result,Model model) {
		//read data Signup form 
		
		if(result.hasErrors()) {
			model.addAttribute("result",result);
			return "Signup";
		}
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		
		return "Login";
	}
	
	@GetMapping("login")
	public String login() {
		return "Login";
	}
}
