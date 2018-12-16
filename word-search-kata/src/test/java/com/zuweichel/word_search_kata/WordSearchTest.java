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
		this.search = new WordSearch(reader.getLetterMatrix(), reader.getSearchWords(), reader.getGridSize());
	}
	
	@Test
	public void find_first_letter() {
		List<Coordinates> locations = new ArrayList<Coordinates>();
		locations.add(new Coordinates(0, 0));
		Assert.assertEquals(locations, search.findFirstLetter("D"));
	}
	
	@Test
	public void find_next_letter() {
		List<WordResult> results = search.findNextLetter("DOG");
		Assert.assertTrue(results.size() == 2);
		Assert.assertEquals("DOG: [(0 0), (1 0)]" , results.get(0).toString());
		Assert.assertEquals("DOG: [(0 0), (1 1)]" , results.get(1).toString());

	}
}
