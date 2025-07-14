package com.dao;

import java.util.ArrayList;

import com.bean.WordBean;

public class WordBeanDao {

	
	public static ArrayList<WordBean> words = new ArrayList<>();

	//class load 
	static {
		
		WordBean w1 = new WordBean();
		w1.setHint("Country");
		w1.setWord("India");
		w1.setDifficulty("EASY");
		
		WordBean w2 = new WordBean();
		w2.setHint("Currency");
		w2.setWord("DOLLAR");
		w2.setDifficulty("MEDIUM");
		
		words.add(w1);
		words.add(w2);
		
		
	}
	
}
