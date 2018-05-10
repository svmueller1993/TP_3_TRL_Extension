package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronHoldsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPatronHolds() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		assertNotNull(p);
	}

	@Test
	void testGetId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		assertTrue(p.getId() == "1");
	}

	@Test
	void testSetId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		p.setId("10");
		assertTrue(p.getId() == "10");
	}

	@Test
	void testGetPatronId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		assertTrue(p.getPatronId() == "2");
	}

	@Test
	void testSetPatronId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		p.setPatronId("20");
		assertTrue(p.getPatronId() == "20");
	}

	@Test
	void testGetHoldId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		assertTrue(p.getHoldId() == "3");
	}

	@Test
	void testSetHoldId() {
		PatronHolds p = new PatronHolds("1", "2", "3");
		p.setHoldId("30");
		assertTrue(p.getHoldId() == "30");
		
	}

}
