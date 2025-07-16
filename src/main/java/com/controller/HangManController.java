package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.WordBean;
import com.dao.WordBeanDao;

@Controller
public class HangManController {

	@GetMapping("/")
	public String root() {
		return "Home";
	}

	@GetMapping("printallwords")
	public String printAllWords() {
		return "AllWords";
	}

	@GetMapping("newword")
	public String newWord() {
		return "NewWord";// jsp
	}

	@PostMapping("saveword")
	public String saveWord(WordBean wordBean) {
		WordBeanDao.words.add(wordBean);
		return "redirect:/printallwords";// url
	}

	@GetMapping("startgame")
	public String startGame(Model model) {

		int index = (int) (Math.random() * WordBeanDao.words.size());
		WordBean wb = WordBeanDao.words.get(index);
		model.addAttribute("word",wb);
		return "Game";
	}
}
