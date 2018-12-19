package com.zuweichel.word_search_kata;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

		for(int x = 0 ; x < matrix.length; x++) {
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
				if(isNextLetterOnBoard(x, y, d)) {
					
					if(matrix[xDir][yDir].equals(word.substring(1,2))) {
						result = new WordResult(word, new ArrayList<Coordinates>());
						result.addCoordinates(new Coordinates(x, y));
						result.addCoordinates(new Coordinates(xDir,yDir));
						result.setDirection(d);
						results.add(result);
					}
				}	
			}
		}
		return results;
	}

	public List<List<WordResult>> checkForRemainingLetters() {
		List<List<WordResult>> allResults = new ArrayList<>();
		List<WordResult> results = null; 
		for(String word: searchWords) {
			results = findNextLetter(word);
			
			for(WordResult result : results) {
				for(int i = 2; i < word.length(); i++) {
					int x = result.getLastLetterCoordinates().getX();
					int y  = result.getLastLetterCoordinates().getY();
					Direction d = result.getDirection();
						
					if(isNextLetterOnBoard(x, y, d)) {
						int xDir = x+d.getX();
						int yDir = y+d.getY();
					
						if(matrix[xDir][yDir].equals(word.substring(i, i+1))) {
							result.addCoordinates(new Coordinates(xDir, yDir));
							allResults.add(results);
						}
					}
				}
			}
		}
		return allResults;
	}
	
	public boolean isNextLetterOnBoard(int x, int y , Direction d) {
		int xDir = x+d.getX();
		int yDir = y+d.getY();
		return xDir >= 0 && yDir >= 0 && xDir < gridSize && yDir < gridSize;
	}

	public Set<WordResult> validateResult(List<List<WordResult>> allResults) {
		Set<WordResult> foundWords = new LinkedHashSet<>();
		for(List<WordResult> results : allResults) {
			for(WordResult result : results) {
				if(result.getCoordinates().size() == result.getWord().length()) {
					foundWords.add(result);
				}
			}
		}
		return foundWords;
	}
	
	public void findWords() {
		List<List<WordResult>> results = checkForRemainingLetters();
		Set<WordResult> words = validateResult(results);
		for(WordResult word : words) {
			System.out.println(word.toString());
		}
	}

}
