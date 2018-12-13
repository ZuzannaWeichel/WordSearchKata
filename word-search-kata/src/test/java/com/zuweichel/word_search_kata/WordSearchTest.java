package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch wordSearch;
	private File file;
	
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
		Assert.assertEquals("UHURA", words[6]);
	}
}
