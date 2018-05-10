package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CopyTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCopy() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		assertNotNull(c);
	}

	@Test
	void testGetId() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.getId();
		assertTrue(c.getId() == "1");
	}

	@Test
	void testSetId() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setId("2");
		assertTrue(c.getId() == "2");
	}

	@Test
	void testGetCondition() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.getCondition();
		assertTrue(c.getCondition() == "Like New");
	}

	@Test
	void testSetCondition() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setCondition("Good");
		c.getCondition();
		assertTrue(c.getCondition() == "Good");
	}

	@Test
	void testIsRented() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.isRented();
		assertTrue(c.isRented() == false);
	}

	@Test
	void testSetRented() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setRented(true);
		assertTrue(c.isRented() == true);
	}

	@Test
	void testGetPrice() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		assertTrue(c.getPrice() == 99.99);
		
	}

	@Test
	void testSetPrice() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setPrice(105.00);
		assertTrue(c.getPrice() == 105.00);
	}

	@Test
	void testGetTextbookId() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setId("1234");
		assertTrue(c.getId() == "1234");
	}

	@Test
	void testSetTextbookId() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setId("1234");
		assertTrue(c.getId() == "1234");
	}

	@Test
	void testSetAudit() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setAudit("Test", "Good", "5/9/2018");
		assertEquals("[Test, Good, 5/9/2018]", c.getAudit().toString());
	}

	@Test
	void testGetAudit() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		c.setAudit("Test", "Good", "5/9/2018");
		assertEquals("[Test, Good, 5/9/2018]", c.getAudit().toString());
	}

	@Test
	void testToString() {
		Copy c = new Copy("1", "Like New", 99.99, false, "123");
		
		assertEquals("Copy [id= 1, condition= Like New, price= 99.99, rented= false, textbookId= 123]", c.toString());
	}

}
