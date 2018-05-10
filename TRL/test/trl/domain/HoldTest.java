package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HoldTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHold() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		assertNotNull(h);
	}

	@Test
	void testGetId() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		assertTrue(h.getId() == "123");
	}

	@Test
	void testSetId() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setId("12");
		assertTrue(h.getId() == "12");
	}

	@Test
	void testGetType() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		assertTrue(h.getType() == "Overdue");
	}

	@Test
	void testSetType() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setType("Damaged");
		assertTrue(h.getType() == "Damaged");
		
	}

	@Test
	void testGetDecription() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		assertTrue(h.getDecription() == "Late Books");
	}

	@Test
	void testSetDecription() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setDecription("Damaged");
		assertTrue(h.getDecription() == "Damaged");
	}

	@Test
	void testGetFine() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		assertTrue(h.getFine() == 45.00);
	}

	@Test
	void testSetFine() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setFine(55.00);
		assertTrue(h.getFine() == 55.00);
	}

	@Test
	void testIsResolved() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setResolved(false);
		assertTrue(h.isResolved() == false);
	}

	@Test
	void testSetResolved() {
		Hold h = new Hold("123", "Overdue", "Late Books", 45.00);
		h.setResolved(true);
		assertTrue(h.isResolved() == true);
	}

}
