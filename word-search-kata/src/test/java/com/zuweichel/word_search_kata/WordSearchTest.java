package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch wordSearch;
	private File file;
	public final int NUMBER_OF_SEARCH_WORDS = 7;
	private final int MATRIX_SIZE = 15;
	
	@Before
	public void setup() throws FileNotFoundException {
		this.file = new File("etc/matrix.txt");
		wordSearch = new WordSearch(file);
	}
	
	@Test
	public void get_search_words() {
		String[] words = wordSearch.getSearchWords();
		Assert.assertTrue(words.length > 0);
		Assert.assertEquals("BONES", words[0]);
		Assert.assertEquals("UHURA", words[NUMBER_OF_SEARCH_WORDS-1]);
	}
	
	@Test
	public void get_letter_matrix() {
		wordSearch.getSearchWords();
		
		String[][] letters = wordSearch.getLetterMatrix(MATRIX_SIZE);
		Assert.assertTrue(letters[0].length == MATRIX_SIZE);
		Assert.assertEquals("U", letters[0][0]);
		Assert.assertEquals("E", letters[0][MATRIX_SIZE-1]);
		Assert.assertEquals("K", letters[MATRIX_SIZE-1][0]);
		Assert.assertEquals("B", letters[MATRIX_SIZE-1][MATRIX_SIZE-1]);	
	}
}
