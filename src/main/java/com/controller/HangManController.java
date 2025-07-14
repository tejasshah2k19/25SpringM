package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.WordBean;
import com.dao.WordBeanDao;

@Controller
public class HangManController {
	
	@GetMapping("printallwords")
	public String printAllWords() {
		return "AllWords";
	}
	
	@GetMapping("newword")
	public String newWord() {
		return "NewWord";//jsp 
	}
	
	@PostMapping("saveword")
	public String saveWord(WordBean wordBean) {
		
		WordBeanDao.words.add(wordBean);
		return "redirect:/printallwords";//url 
		
	}
}
