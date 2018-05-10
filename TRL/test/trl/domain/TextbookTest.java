package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextbookTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTextbook() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertNotNull(t);
	}

	@Test
	void testGetId() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertTrue(t.getId() == "1");
	}

	@Test
	void testSetId() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		t.setId("10");
		assertTrue(t.getId() == "10");
	}

	@Test
	void testGetIsbn() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertTrue(t.getIsbn() == "123");
	}

	@Test
	void testSetIsbn() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		t.setIsbn("1234");
		assertTrue(t.getIsbn() == "1234");
	}

	@Test
	void testGetTitle() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertTrue(t.getTitle() == "Test");
	}

	@Test
	void testSetTitle() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		t.setTitle("This is a Test");
		assertTrue(t.getTitle() == "This is a Test");
	}

	@Test
	void testGetAuthor() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertTrue(t.getAuthor() == "Testing");
	}

	@Test
	void testSetAuthor() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		t.setAuthor("Testing This");
		assertTrue(t.getAuthor() == "Testing This");
	}

	@Test
	void testToString() {
		Textbook t = new Textbook("1", "123", "Test", "Testing");
		assertEquals(t.toString(), "Textbook [id=" + t.getId() + ", isbn=" + t.getIsbn() + ", title=" + t.getTitle() + ", author=" + t.getAuthor() + "]");
	}

}
