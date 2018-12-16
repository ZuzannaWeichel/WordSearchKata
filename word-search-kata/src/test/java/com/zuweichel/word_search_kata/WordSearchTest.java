package com.zuweichel.word_search_kata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	private WordSearch search;
	private FileReader reader;
	private File file;
	
	@Before
	public void setup() throws FileNotFoundException {
		this.file = new File("etc/miniMatrix.txt");
		this.reader = new FileReader(file);
		this.search = new WordSearch(reader.getLetterMatrix(), reader.getSearchWords());
	}
	
	@Test
	public void find_first_letter() {
		List<int[]> locations = new ArrayList<>();
		locations.add(new int[] {0,0});
		Assert.assertArrayEquals(locations.get(0), search.findFirstLetter("D").get(0));
	}
	
	
}
