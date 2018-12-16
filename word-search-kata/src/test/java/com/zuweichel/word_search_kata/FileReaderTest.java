package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

	private FileReader reader;
	private File file;
	
	@Before
	public void setup() throws FileNotFoundException {
		this.file = new File("etc/miniMatrix.txt");
		this.reader = new FileReader(file);
		
	}
	
	@Test
	public void get_search_words() {
		String[] words = reader.getSearchWords();
		Assert.assertTrue(words.length > 0);
		Assert.assertEquals("DOG", words[0]);
		Assert.assertEquals("CAT", words[words.length-1]);
	}
	
	@Test
	public void get_letter_matrix() {	
		String[][] letters = reader.getLetterMatrix();
		Assert.assertTrue(letters[0].length == letters.length);
		Assert.assertEquals("D", letters[0][0]);
		Assert.assertEquals("G", letters[0][letters.length-1]);
		Assert.assertEquals("C", letters[letters.length-1][0]);
		Assert.assertEquals("T", letters[letters.length-1][letters.length-1]);	
	}
	
}
