package com.zuweichel.word_search_kata;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class WordSearch {
	
	String[][] matrix;
	String[] searchWords;
	List<Direction> directions;
	int gridSize;
	
	public WordSearch(String [][] matrix, String[] searchWords, int gridSize) {
		this.matrix = matrix;
		this.searchWords = searchWords;
		this.directions = new ArrayList<Direction>(EnumSet.allOf(Direction.class));
		this.gridSize = gridSize;
	}

	public List<Coordinates> findFirstLetter(String letter) {
		List<Coordinates> lettersFound = new ArrayList<Coordinates>();

		for(int x = 0 ; x < matrix.length-1; x++) {
			for(int y = 0 ; y < matrix[x].length-1; y++) {
				if(letter.equals(matrix[x][y])) {
					lettersFound.add(new Coordinates(x, y));
				}
			}
		}
		return lettersFound;
	}

	public List<WordResult> findNextLetter(String word) {
		
		List<WordResult> results = new ArrayList<>();
		List<Coordinates> firstLetters = findFirstLetter(word.substring(0,1));
		WordResult result = null;
		int x;
		int y;
		
		for(Coordinates firstLetter : firstLetters) {
			
			x = firstLetter.getX();
			y = firstLetter.getY();
		
			for(Direction d : directions) {
				int xDir = x+d.getX();
				int yDir = y+d.getY();
				if(xDir >= 0 && yDir >= 0 && xDir < gridSize && yDir < gridSize) {
					
					if(matrix[xDir][yDir].equals(word.substring(1,2))) {
						result = new WordResult(word, new ArrayList<Coordinates>());
						result.addCoordinates(new Coordinates(x, y));
						result.addCoordinates(new Coordinates(xDir,yDir));
						result.setDirection(d);
						results.add(result);
						System.out.println(xDir+" "+yDir+" gridSize "+ gridSize+ " direction: "+d);
					}
				}	
			}
		}
		System.out.println(results);
		return results;
	}
}
