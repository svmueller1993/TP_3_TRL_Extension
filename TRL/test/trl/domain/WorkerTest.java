package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testWorker() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		assertNotNull(w);
	}

	@Test
	void testGetWorkerId() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		assertTrue(w.getWorkerId() == "1");
	}

	@Test
	void testSetWorkerId() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		w.setWorkerId("10");
		assertTrue(w.getWorkerId() == "10");
	}

	@Test
	void testGetFirstName() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		assertTrue(w.getFirstName() == "Test");
	}

	@Test
	void testSetFirstName() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		w.setFirstName("Tester");
		assertTrue(w.getFirstName() == "Tester");
	}

	@Test
	void testGetLastName() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		assertTrue(w.getLastName() == "Testing");
		
	}

	@Test
	void testSetLastName() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		w.setLastName("Testing1");
		assertTrue(w.getLastName() == "Testing1");
	}

	@Test
	void testGetPassword() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		assertTrue(w.getPassword() == "Password");
	}

	@Test
	void testSetPassword() {
		Worker w = new Worker("1", "Test", "Testing", "Password");
		w.setPassword("Password123!");
		assertTrue(w.getPassword() == "Password123!");
	}

}
