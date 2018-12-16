package com.zuweichel.word_search_kata;

import java.util.List;

public class WordResult {

	private String word;
	private List<Coordinates> coordinates;
	private Direction direction;
	
	public WordResult(String word, List<Coordinates> coordinates) {
		this.word = word;
		this.coordinates = coordinates;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}
	
	public void addCoordinates(Coordinates coordinates) {
		this.coordinates.add(coordinates);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Coordinates getLastLetterCoordinates() {
		return coordinates.get(coordinates.size()-1);
	}
	
	@Override
	public String toString() {
		return word+": "+coordinates;
	}
	
	
}
