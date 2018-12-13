package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearch {

	File file;
	Scanner reader;
	
	public WordSearch(File file) throws FileNotFoundException {
		this.file = file;
		reader = new Scanner(file);
	}

	public String[] getSearchWords() {
		String [] searchWords = reader.nextLine().split(",");
		return searchWords;
	}

	public String[][] getLetterMatrix(int size) {
		String [][] letters = new String [size][];
		int i = 0;
		while(reader.hasNextLine()) {
			letters[i] = reader.nextLine().split(",");
			System.out.println(Arrays.toString(letters[i]));
			i++;
		}
		return letters;
	}
	
	public void findWords(int size) {
		getSearchWords();
		getLetterMatrix(size);
	}
}
