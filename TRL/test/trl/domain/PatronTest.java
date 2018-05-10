package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPatron() {
		Patron p = new Patron("1", "Test", "Testing", true);
		assertNotNull(p);
	}

	@Test
	void testGetPatronId() {
		Patron p = new Patron("1", "Test", "Testing", true);
		assertTrue(p.getPatronId() == "1");
	}

	@Test
	void testSetPatronId() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setPatronId("123");
		assertTrue(p.getPatronId() == "123");
	}

	@Test
	void testGetFirstName() {
		Patron p = new Patron("1", "Test", "Testing", true);
		assertTrue(p.getFirstName() == "Test");
	}

	@Test
	void testSetFirstName() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setFirstName("Patron");
		assertTrue(p.getFirstName() == "Patron");
	}

	@Test
	void testGetLastName() {
		Patron p = new Patron("1", "Test", "Testing", true);
		assertTrue(p.getLastName() == "Testing");
	}

	@Test
	void testSetLastName() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setLastName("Patron");
		assertTrue(p.getLastName() == "Patron");
	}

	@Test
	void testGetPhone() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setPhone("000-000-0000");
		assertTrue(p.getPhone() == "000-000-0000");
	}

	@Test
	void testSetPhone() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setPhone("000-000-0000");
		assertTrue(p.getPhone() == "000-000-0000");
	}

	@Test
	void testIsActive() {
		Patron p = new Patron("1", "Test", "Testing", true);
		assertTrue(p.isActive() == true);
	}

	@Test
	void testSetActive() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setActive(false);
		assertTrue(p.isActive() == false);
	}

	@Test
	void testGetAccountType() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setAccountType("Patron");
		assertTrue(p.getAccountType() == "Patron");
	}

	@Test
	void testSetAccountType() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setAccountType("Patron");
		assertTrue(p.getAccountType() == "Patron");
	}

	@Test
	void testGetAddress() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setAddress("123 Test Street, Minneapolis MN, 55454");
		assertTrue(p.getAddress() == "123 Test Street, Minneapolis MN, 55454");
	}

	@Test
	void testSetAddress() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setAddress("123 Test Street, Minneapolis MN, 55454");
		assertTrue(p.getAddress() == "123 Test Street, Minneapolis MN, 55454");
	}

	@Test
	void testIsOverdueHold() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setOverdueHold(false);
		assertTrue(p.isOverdueHold() == false);
	}

	@Test
	void testSetOverdueHold() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setOverdueHold(false);
		assertTrue(p.isOverdueHold() == false);
	}

	@Test
	void testToString() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setPhone("000-000-0000");
		p.setAccountType("Patron");
		p.setAddress("123 Test Street, Minneapolis MN, 55454");
		p.setOverdueHold(false);
		
		assertEquals("Patron [patronId= " + p.patronId + ", firstName= " + p.firstName + ", lastName= " + p.lastName + ", phone= "
				+ p.phone + ", active= " + p.active + ", accountType= " + p.accountType + ", address= " + p.address
				+ ", overdueHold= " + p.overdueHold + "]", p.toString());
		
	}

}
