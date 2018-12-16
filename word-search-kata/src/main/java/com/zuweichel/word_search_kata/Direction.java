package com.zuweichel.word_search_kata;

public enum Direction {

	UP (-1, 0), 
	UP_LEFT (-1, -1), 
	UP_RIGHT (-1, +1),
	LEFT (0, -1), 
	RIGHT (0, +1),
	DOWN (+1, 0), 
	DOWN_LEFT (+1, -1), 
	DOWN_RIGHT (+1, +1);
	
	private int x;
	private int y;
	
	private Direction( int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
