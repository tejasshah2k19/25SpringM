package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.WordBean;
import com.dao.WordBeanDao;

import jakarta.servlet.http.HttpSession;

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
	public String startGame(Model model, HttpSession session) {

		int index = (int) (Math.random() * WordBeanDao.words.size());
		WordBean wb = WordBeanDao.words.get(index);
		session.setAttribute("wb", wb);
		session.setAttribute("word", wb.getWord());
		session.setAttribute("life", 3);
		session.setAttribute("guessCorrectChar", new ArrayList<>());
		return "Game";
	}

	@PostMapping("checkword")
	public String checkWord(String guessChar,HttpSession session) {
		String word = (String)session.getAttribute("word");
		int life = (int)session.getAttribute("life");
		
		if(word.toLowerCase().contains(guessChar.toLowerCase())) {
				//compare => 
			
		}else {
			life--;
			session.setAttribute("life", life);
		}
		return "Game";
	}

}
