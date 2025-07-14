package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EmployeeBean;

@Controller
public class EmployeeController {

	@GetMapping("newemp")
	public String newEmp() {
		return "NewEmp";
	}

	@PostMapping("saveemp")
	public String saveEmp(@Validated EmployeeBean emp, BindingResult result, Model model) {

		if (!emp.isPasswordMatching()) {
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"Passwords and Confirm Password must be same");
		}
		if (result.hasErrors()) {
			model.addAttribute("result", result);
			model.addAttribute("emp", emp);//
			return "NewEmp";
		}
		return "Login";
	}
}
