package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		File file = new File("etc/matrix.txt");
		try {
			WordSearch wordSearch = new WordSearch(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//WordSearch.findWords();
	}

}