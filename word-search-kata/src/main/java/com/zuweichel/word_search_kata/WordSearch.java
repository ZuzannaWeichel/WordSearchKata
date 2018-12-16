package com.zuweichel.word_search_kata;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
	String[][] matrix;
	String[] searchWords;
	
	public WordSearch(String [][] matrix, String[] searchWords) {
		this.matrix = matrix;
		this.searchWords = searchWords;
	}

	public List<int[]> findFirstLetter(String letter) {
		List<int[]> lettersFound = new ArrayList<>();

		for(int x = 0 ; x < matrix.length-1; x++) {
			for(int y = 0 ; y < matrix[x].length-1; y++) {
				if(letter.equals(matrix[x][y])) {
					lettersFound.add(new int[]{x,y});
				}
			}
		}
		return lettersFound;
	}
}
