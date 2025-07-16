package com.dao;

import java.util.ArrayList;

import com.bean.WordBean;

public class WordBeanDao {

	public static ArrayList<WordBean> words = new ArrayList<>();

	// class load
	static {

		WordBean w1 = new WordBean();
		w1.setHint("Country");
		w1.setWord("India");
		w1.setDifficulty("EASY");

		WordBean w2 = new WordBean();
		w2.setHint("Currency");
		w2.setWord("DOLLAR");
		w2.setDifficulty("MEDIUM");

		WordBean w3 = new WordBean();
		w3.setHint("Fruit");
		w3.setWord("MANGO");
		w3.setDifficulty("EASY");

		WordBean w4 = new WordBean();
		w4.setHint("Animal");
		w4.setWord("ELEPHANT");
		w4.setDifficulty("MEDIUM");

		WordBean w5 = new WordBean();
		w5.setHint("Planet");
		w5.setWord("MARS");
		w5.setDifficulty("EASY");

		WordBean w6 = new WordBean();
		w6.setHint("Programming Language");
		w6.setWord("PYTHON");
		w6.setDifficulty("HARD");

		WordBean w7 = new WordBean();
		w7.setHint("Capital of Japan");
		w7.setWord("TOKYO");
		w7.setDifficulty("MEDIUM");

		WordBean w8 = new WordBean();
		w8.setHint("Longest River");
		w8.setWord("NILE");
		w8.setDifficulty("HARD");
		WordBean w9 = new WordBean();
		w9.setHint("Famous Scientist");
		w9.setWord("EINSTEIN");
		w9.setDifficulty("HARD");

		WordBean w10 = new WordBean();
		w10.setHint("Ocean");
		w10.setWord("PACIFIC");
		w10.setDifficulty("MEDIUM");

		WordBean w11 = new WordBean();
		w11.setHint("Sport");
		w11.setWord("CRICKET");
		w11.setDifficulty("EASY");

		WordBean w12 = new WordBean();
		w12.setHint("Social Media Platform");
		w12.setWord("INSTAGRAM");
		w12.setDifficulty("MEDIUM");

		words.add(w1);
		words.add(w2);
		words.add(w3);
		words.add(w4);
		words.add(w5);
		words.add(w6);
		words.add(w7);
		words.add(w8);
		words.add(w9);
		words.add(w10);
		words.add(w11);
		words.add(w12);

	}

}
