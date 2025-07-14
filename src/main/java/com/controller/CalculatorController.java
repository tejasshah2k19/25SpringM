package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CalcBean;

@Controller
public class CalculatorController {

	@GetMapping("/calc") // url
	public String openCalculator() { // method name
		return "Calculator"; // jsp name
	}

	@GetMapping("/addcalc")
	public String openAddCalculator() {
		return "AddCalculator";
	}

	@PostMapping("/addition")
	public String addition(CalcBean calcBean,Model model) {
		//read
		//addition print 
		System.out.println(calcBean.getN1()+calcBean.getN2());
		
		//send addition to next jsp 
		model.addAttribute("ans",calcBean.getN1()+calcBean.getN2());
		return "Ans";//jsp
	}

}
