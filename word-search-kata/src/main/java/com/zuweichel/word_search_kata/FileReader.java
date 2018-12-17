package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	File file;
	Scanner reader;
	List<String> rows;
	
	public FileReader(File file) throws FileNotFoundException {
		this.file = file;
		reader = new Scanner(file);
		rows =  new ArrayList<>();
		readInputToList(reader);
	}
	
	private void readInputToList(Scanner reader){
		while (reader.hasNext()) {
			rows.add(reader.nextLine());
		}
	}
	
	public int getGridSize() {
		return rows.size()-1;
	}
		
	public String[] getSearchWords() {
		String [] searchWords = rows.get(0).split(",");
		return searchWords;
	}

	public String[][] getLetterMatrix() {
		int size = rows.size()-1;
		String [][] letters = new String [size][];
		int index = 0;
		for(int i = 1; i <= size ; i++ ){
			letters[index] = rows.get(i).split(",");
			index++;
		}
		return letters;
	}
}
