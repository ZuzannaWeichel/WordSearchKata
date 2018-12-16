package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("etc/matrix.txt");
		FileReader reader = new FileReader(file);
		WordSearch search = new WordSearch(reader.getLetterMatrix(), reader.getSearchWords(), reader.getGridSize());
		
	String dog = "DOG";
	System.out.println(dog.substring(0, 1));
	System.out.println(dog.substring(1, 2));
		
	}

}
